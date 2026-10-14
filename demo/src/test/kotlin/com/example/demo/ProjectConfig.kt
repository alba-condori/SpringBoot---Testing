package com.ejemplo.demo // Usa el mismo paquete raíz de tus tests

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.extensions.spring.SpringExtension

class ProjectConfig : AbstractProjectConfig() {  override val extensions = listOf(SpringExtension())}