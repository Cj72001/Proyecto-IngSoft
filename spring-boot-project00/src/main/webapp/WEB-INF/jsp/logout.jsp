<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel ="stylesheet" href="/style/login.css">
    <title>Login</title>
</head>

<body>
  <div class="main">
      
    <form method="post" action="index.html">
      <img clas="box" src="/img/login.jpg" width="200px"/>
      <div class="box">
        <input type="carnet" name="carnet" placeholder="Carnet" onFocus="field_focus(this, 'carnet');" onblur="field_blur(this, 'carnet');" class="carnet" />
        <input type="password" name="password" placeholder="Contraseña" onFocus="field_focus(this, 'password');" onblur="field_blur(this, 'password');" class="carnet" />
      </div> <!-- End Box -->
    </form>

    <div>
      <div>
        <a href="mainPage.html"><div class="box1">Entrar</div></a> <!-- End Btn -->
      </div>
      <div>
        <a href="passwordRecover.html">Recuperar contraseña</a>
      </div>
      <div>
        <a href="register.html">Registrarse</a>
      </div>
  </div>

  </div>

</body>
</html>