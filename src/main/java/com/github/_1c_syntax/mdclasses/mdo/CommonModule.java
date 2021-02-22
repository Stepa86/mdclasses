/*
 * This file is a part of MDClasses.
 *
 * Copyright © 2019 - 2021
 * Tymko Oleg <olegtymko@yandex.ru>, Maximov Valery <maximovvalery@gmail.com> and contributors
 *
 * SPDX-License-Identifier: LGPL-3.0-or-later
 *
 * MDClasses is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3.0 of the License, or (at your option) any later version.
 *
 * MDClasses is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with MDClasses.
 */
package com.github._1c_syntax.mdclasses.mdo;

import com.github._1c_syntax.mdclasses.mdo.wrapper.DesignerMDO;
import com.github._1c_syntax.mdclasses.metadata.additional.MDOType;
import com.github._1c_syntax.mdclasses.metadata.additional.ReturnValueReuse;
import com.github._1c_syntax.mdclasses.unmarshal.annotation.TypeAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@TypeAlias(edtName = "mdclass:CommonModule")
public class CommonModule extends MDObjectBSL {

  /**
   * Признак Сервер
   */
  private boolean server;

  /**
   * Признак Глобальный
   */
  private boolean global;

  /**
   * Признак Клиент-управляемое приложение
   */
  private boolean clientManagedApplication;

  /**
   * Признак Внешнее соединение
   */
  private boolean externalConnection;

  /**
   * Признак Клиент-обычное приложение
   */
  private boolean clientOrdinaryApplication;

  /**
   * Признак Вызов сервера
   */
  private boolean serverCall;

  /**
   * Признак Привилегированный режим
   */
  private boolean privileged;

  /**
   * Режим повторного использования значений
   */
  private ReturnValueReuse returnValuesReuse = ReturnValueReuse.DONT_USE;

  public CommonModule(DesignerMDO designerMDO) {
    super(designerMDO);
    server = designerMDO.getProperties().isServer();
    global = designerMDO.getProperties().isGlobal();
    clientManagedApplication = designerMDO.getProperties().isClientManagedApplication();
    externalConnection = designerMDO.getProperties().isExternalConnection();
    clientOrdinaryApplication = designerMDO.getProperties().isClientOrdinaryApplication();
    serverCall = designerMDO.getProperties().isServerCall();
    privileged = designerMDO.getProperties().isPrivileged();
    returnValuesReuse = designerMDO.getProperties().getReturnValuesReuse();
  }

  @Override
  public MDOType getType() {
    return MDOType.COMMON_MODULE;
  }

}
