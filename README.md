# Swagger Bookstore API
In diesem Beispiel wird gezeigt, wie anhand einer beispielhaften OpenAPI Spezifikation, der dazugehörige Server-Code generiert werden kann. Das Repository ist dabei in unterschiedliche Branches gegliedert, welche die angebotenen Möglichkeiten näher untersucht.

## Branch 'second-approach'
In diesem Ansatz wird die Code-Generierung in Maven Build Prozess integriert. Dazu wird wie folgt vorgegangen:
1. Das initiale Maven-Projekt wird mit der Swagger-Codegen-CLI erzeugt
2. Das [Maven-Plugin für den Swagger-Codegen](https://github.com/swagger-api/swagger-codegen/tree/master/modules/swagger-codegen-maven-plugin) wird manuell in die `pom.xml` Datei integriert 

## Initiale MVN-Projekt
- API Spezifikation in der Datei `api.yml` speichern
- SwaggerCodegen Konfig-Datei in `config.json` speichern (siehe Branch first_approach)
- Swagger-Codegen-CLI ausführen: `swagger-codegen generate -i api.yaml -l spring -o ./server -c ./config.json`

## Maven-Plugin für den Swagger-Codegen
- Die `pom.xml` Datei erweitern um folgendes Plugin:
```
<plugin>
    <groupId>io.swagger</groupId>
    <artifactId>swagger-codegen-maven-plugin</artifactId>
    <version>2.3.1</version>
    <executions>
        <execution>
            <goals>
                <goal>generate</goal>
            </goals>
            <configuration>
                <inputSpec>${project.basedir}/src/main/resources/api.yaml</inputSpec>
                <language>spring</language>
                <configOptions>
                    <delegatePattern>true</delegatePattern>
                </configOptions>
            </configuration>
        </execution>
    </executions>
</plugin>
```
- Die API-Spezifikation (`api.yaml`) verschieben in das Verzeichnis: `server/src/main/resources/`
- Die CodeGen Konfiguration (`config.json`) löschen
- Ins Server Verzeichnis wechseln und den CodeGenerator starten: `mvn clean generate-sources`

# Test
- `curl -X GET "http://localhost:8080/v0/books"`