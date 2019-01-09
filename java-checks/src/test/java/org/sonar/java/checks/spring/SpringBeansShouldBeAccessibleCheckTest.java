/*
 * SonarQube Java
 * Copyright (C) 2012-2019 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.java.checks.spring;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.sonar.java.checks.verifier.MultipleFilesJavaCheckVerifier;

public class SpringBeansShouldBeAccessibleCheckTest {

  @Test
  public void testComponentScan() {
    List<String> files = Arrays.asList(
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/A.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/B.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/C.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/DefaultPackage.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/FalsePositive.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/Y1.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/Y2.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/Z2.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/ComponentScan/ComponentScan.java");
    MultipleFilesJavaCheckVerifier.verify(files, new SpringBeansShouldBeAccessibleCheck());
    MultipleFilesJavaCheckVerifier.verifyNoIssueWithoutSemantic(files, new SpringBeansShouldBeAccessibleCheck());
  }

  @Test
  public void testSpringBootApplication() {
    List<String> files = Arrays.asList(
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/SpringBootApplication/Ko.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/SpringBootApplication/SpringBoot.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/SpringBootApplication/AnotherSpringBoot.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/SpringBootApplication/AnotherOk.java",
      "src/test/files/checks/spring/SpringBeansShouldBeAccessibleCheck/SpringBootApplication/Ok.java");
    MultipleFilesJavaCheckVerifier.verify(files, new SpringBeansShouldBeAccessibleCheck());
    MultipleFilesJavaCheckVerifier.verifyNoIssueWithoutSemantic(files, new SpringBeansShouldBeAccessibleCheck());
  }

}
