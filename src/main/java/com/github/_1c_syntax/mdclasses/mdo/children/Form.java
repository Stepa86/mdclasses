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
package com.github._1c_syntax.mdclasses.mdo.children;

import com.github._1c_syntax.mdclasses.mdo.AbstractMDObjectBSL;
import com.github._1c_syntax.mdclasses.mdo.AbstractMDObjectBase;
import com.github._1c_syntax.mdclasses.mdo.MDOForm;
import com.github._1c_syntax.mdclasses.mdo.children.form.FormData;
import com.github._1c_syntax.mdclasses.mdo.metadata.Metadata;
import com.github._1c_syntax.mdclasses.mdo.support.MDOType;
import com.github._1c_syntax.mdclasses.unmarshal.wrapper.DesignerMDO;
import com.github._1c_syntax.mdclasses.utils.MDOFactory;
import com.github._1c_syntax.mdclasses.utils.MDOPathUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.nio.file.Path;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Metadata(
  type = MDOType.FORM,
  name = "Form",
  nameRu = "Форма",
  groupName = "Forms",
  groupNameRu = "Формы"
)
public class Form extends AbstractMDObjectBSL implements MDOForm {
  /**
   * Данные формы. Читается из отдельного файла
   * и предоставляет информацию о:
   * + список элементов формы
   * + список обработчиков формы
   * + список реквизитов формы
   */
  private FormData data;

  /**
   * Путь к файлу с данными формы
   */
  private Path formDataPath;

  public Form(DesignerMDO designerMDO) {
    super(designerMDO);
  }

  @Override
  public void supplement(AbstractMDObjectBase parent) {
    super.supplement(parent);
    formDataPath = MDOPathUtils.getFormDataPath(this);
    MDOFactory.readFormData(formDataPath).ifPresent(this::setData);
  }
}
