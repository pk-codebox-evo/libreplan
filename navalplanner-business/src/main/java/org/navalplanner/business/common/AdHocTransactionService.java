/*
 * This file is part of ###PROJECT_NAME###
 *
 * Copyright (C) 2009 Fundación para o Fomento da Calidade Industrial e
 *                    Desenvolvemento Tecnolóxico de Galicia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.navalplanner.business.common;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdHocTransactionService implements IAdHocTransactionService {

    @Override
    @Transactional
    public <T> T runOnTransaction(IOnTransaction<T> onTransaction) {
        return onTransaction.execute();
    }

    @Override
    @Transactional(readOnly = true)
    public <T> T runOnReadOnlyTransaction(IOnTransaction<T> onTransaction) {
        return onTransaction.execute();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public <T> T runOnAnotherTransaction(IOnTransaction<T> onTransaction) {
        return onTransaction.execute();
    }

}
