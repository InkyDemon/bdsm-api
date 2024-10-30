<h1 align="center">BDSM API (BG Drianick Sigma Mod)</h1>
<p align="center">BDSM API - это мод-библиотека, добавляющий конструкторы для упрощённого моддинга на ядре Fabric.</p>
<h3>Как добавить в проект?:</h3>

```gradle
repositories {
  maven {
    name = "JitPack"
    url = "https://jitpack.io" 
  }
}

dependencies {
  //0.1 - Последняя версия
  modApi "com.github.InkyDemon:bdsm-api:0.1"
  //include если собираетесь вшить в проект
  include "com.github.InkyDemon:bdsm-api:0.1"
}
```
