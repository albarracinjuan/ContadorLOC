Para descargar y empaquetar proyecto siga estos pasos: 

1. Abrir una terminal de comandos.
2. Ubicarse en el directorio en donde desea descargar el proyecto.
3. Descargar el proyecto utilizando el comando $ git clone https://github.com/albarracinjuan/ContadorLOC.git <nombre_nuevo>,
   en dónde <nombre_nuevo> es el nombre que le va a dar al proyecto.
4. Por último ubicarse en el directorio del proyecto "directorio seleccionado paso 2/<nombre_nuevo> paso 3/" y ejecutar el comando mvn package.

Nota: si desea ejecutar el proyecto, desde una terminal de comandos ubicarse en "directorio seleccionado paso 2/<nombre_nuevo> paso 3/target/classes"  y
ejecutar el comando java edu.uniandes.ecos.ContadorLOC.vista.VentanaPrincipal