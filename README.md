 FUTWR  Aplicació Android ACT 06

Feina treballada

Pantalla de SplashScreen 
Menú de Navegació: Accés ràpid mitjançant un menú desplegable a totes les seccions de l'aplicació.

Llistes Dinàmiques Múltiples RecyclerView

Notícies Principals:Llistat interactiu amb imatges, resums i esdeveniments de targetes.

Els Meus Comentaris "MisComentariosActivity": Pantalla dedicada exclusivament a mostrar un llistat de comentaris
de text de l'usuari sobre els partits, tambe es pot fer modificació i eliminació mitjançant una pulsació llarga .
Seccions d'Ajuda i Solucions: Millorades integrant el logotip oficial a la capçalera.

Sistema de Traces Log.d i Toast: Registre d'esdeveniments sota l'etiqueta "FUTWR_EVENT".

Accessibilitat i Correccions 

Després de la revisió de l'Activitat 05 he millorat
Atributs android:contentDescription en tots els components gràfics, icones i botons .
Mides de tipografia estandarditzades en unitats sp per assegurar l'escalabilitat correcta del text.
Àrees tàctils optimitzades agrandant mínima de 48x48dp en elements interactius i barres de navegació.


FUTWR  Aplicació Android ACT 07.1
Aquesta activitat aplica el patró MVVM amb LiveData a les pantalles de Login i Registre del projecte FUTWR.

Les Activities (LoginActivity i RegisterActivity) s'encarreguen només de la interfície d'usuari: recullen el que escriu l'usuari i observen els canvis dels ViewModels amb observe.

Els ViewModels (LoginViewModel i RegisterViewModel) contenen tota la lògica de validació (camps buits, format del correu i longitud de les dades) i exposen dos LiveData: errorMessage (per avisar si hi ha algun error) i loginResult / registerResult (per indicar si la validació ha anat bé).

D'aquesta manera la lògica queda separada de la vista i la pantalla reacciona automàticament quan l'usuari intenta iniciar sessió o registrar-se amb dades incorrectes o vàlides.

Accesibilitat:Apart de canvis pendents i millores en aquesta activitat concreta no s'ha treballat l'accesibilitat degut a que no es demana.
