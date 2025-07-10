Feature: Yo como usuario
         quiero logearme en la pagina buggy cars
         para poder acceder a los servicios de la pagina

  Scenario: Login exitoso con credenciales validas
    Given que un usuario esta en la pagina de inicio de Buggy Cars Rating
    When el usuario se loguea con "123elsimon@gmail.com" y "Simon123."
    Then el usuario deberia ver la pagina de inicio

  Scenario: Login fallido con credenciales invalidas
    Given que un usuario esta en la pagina de inicio de Buggy Cars Rating
    When el usuario intenta loguearse con "invalid_user" y "wrong_password"
    Then el usuario deberia ver el mensaje de error "Invalid username/password"

  Scenario: Login fallido con campo de usuario vacio
    Given que un usuario esta en la pagina de inicio de Buggy Cars Rating
    When el usuario intenta loguearse con "" y "cualquierContrasenia"
    Then el usuario deberia ver el mensaje de validacion del navegador "Completa este campo" para el campo de "usuario"

  Scenario: Login fallido con campo de contrasena vacio
    Given que un usuario esta en la pagina de inicio de Buggy Cars Rating
    When el usuario intenta loguearse con "cualquierUsuario" y ""
    Then el usuario deberia ver el mensaje de validacion del navegador "Completa este campo" para el campo de "contrasena"

  Scenario: Login fallido con ambos campos vacios
    Given que un usuario esta en la pagina de inicio de Buggy Cars Rating
    When el usuario intenta loguearse con "" y ""
    Then el usuario deberia ver el mensaje de validacion del navegador "Completa este campo" para el campo de "usuario"