# WRN-API für Minecraft 26.3

Diese Ausgabe aktualisiert WRN-API 1.0 für Minecraft 26.3 und Java 25.

- Spigot-API und Plugin-Deskriptor auf 26.3 aktualisiert.
- Der Entwicklermodus erkennt die neuen 26.3-/26.3.x-Plugins und unterstützt weiterhin die zuvor erlaubten 1.21-/1.21.x-Versionen. Ähnliche Versionspräfixe wie 26.30 werden abgelehnt.
- Java 25 wird zum Bauen und Ausführen benötigt.

## Installation

Server stoppen und vorhandene Plugin-Daten sichern. Die alte WRN-API-JAR im Ordner `plugins/` durch `wrn-api-1.0.jar` ersetzen und den Server neu starten. LifeCore 2.1 benötigt diese aktuelle WRN-API zusätzlich zu seiner eigenen JAR.

`SHA256SUMS` enthält die Prüfsumme genau dieser Release-JAR. Der Release-Tag `mc26.3` kennzeichnet die Minecraft-Kompatibilität; die interne Plugin-Version bleibt 1.0.

## Prüfung

Der Release-Workflow baut den getaggten Quellstand mit Java 25 und führt `mvn clean verify` einschließlich vier Regressionstests zur Versionsprüfung aus. Er veröffentlicht die daraus erzeugte JAR. Ein manueller Server-/Mehrspielertest wurde nicht durchgeführt.
