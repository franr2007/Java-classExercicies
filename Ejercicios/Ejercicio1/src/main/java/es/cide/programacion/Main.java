package es.cide.programacion;

//Francisco Javier Rodriguez

public class Main {
    public static void main(String[] args) {
       
    //Identificar identificadores correctos 

        int registro1; //Este es correcto
        //int 1registro; //Este es incorrecto porque empieza con un numero
        int archivo_3; //Este es correcto
        //int while; //Este es incorrecto porque utiliza una funcion como variable
        int $impuesto; //Este es correcto
        int año; //Este es correcto
        //int primer apellido; //Este es incorrecto porque utiliza un espacio
        int primer_apellido; //Este es correcto
        //int primer-apellido; //Este es incorrecto porque utiliza un simbolo numerico
        int primerApellido; //Este es correcto
        //int Tom's'; //Este es incorrecto porque utiliza la comilla
        int C3PO; //Este es correcto
        //int 123#; //Este es incorrecto porque empieza con un numero
        //int PesoMáximo; //Este es incorrecto porque utiliza un acento
        //int %descuento; //Este es incorrecto porque utiliza un simbolo numerico
        //int Weight; //Este es incorrecto porque utiliza una funcion
        //int $$precioMínimo; //Este es incorrecto porque utiliza acento
        //int _$Único; //Este es incorrecto porque utiliza acento
        //int tamaño_màximo //Este es incorrecto porque utiliza acento y utiliza una letra inusual
        //int peso.maximo; //Este es incorrecto porque utiliza un punto
        int Precio__; //Este es correcto
        //int matrícula?; //Este es incorrecto porque utiliza un acento y utiliza un interrogante
        //int cuántoVale; //Este es incorrecto porque utiliza un acento
        int high; //Este es correcto
        //int barça; //Este es incorrecto porque utiliza un carcater inusual
        //int piragüista; //Este es incorrecto porque utiliza una dieresis
        int B_011; //Este es correcto
        int X012AB; //Este es correcto
        //int 70libro //Este es incorrecto porque empieza con un numero
        //int nombre&apellido; //Este es incorrecto porque utiliza un &
        //int 0X1A //Este es incorrecto porque empieza con un numero
        //int else //Este es incorrecto porque utiliza una funcion

    //Identificar los literales correctos

        double uno=0.5; //Se utiliza double porque da error float y se utiliza porque es un numero real, es decir con coma flotante con menos de 7 digitos
        System.out.println(uno); //Esto imprime la variable marcada
        double dos=.5; //Es correcto, da el mismo valor que el anterior, detecta que antes de la coma va algo y lo interpreta como un 0
        System.out.println(dos);
        double tres=9.3e12; //Se utiliza double porque es un numero real con menos o = de 16 digitos
        System.out.println(tres);
        double cuatro=9.3e-12; //Se utiliza double porque es un numero real con menos o = de 16 digitos
        System.out.println(cuatro);
        int cinco=12345678; //Se utiliza int porque son numeros enteros entre un rango de 2147483647
        System.out.println(cinco);
        //long seis=12345678_L; //Este es incorrecto utiliza un caracter especial, pero se deberia usar long ya que la "L" lo indica
        //double siete=0.8E+0.8; //Este es incorrecto porque eleva un numero a 0.8
        //double ocho=0.8E 8; //Este es incorrecto porque utiliza un espacio en medio del valor de la variable
        short nueve=05_15; //Se utiliza un short porque es un numero entero entre un rango de 32767 y funciona porque java lo interpreta como octal ya que empieza con 0
        System.out.println(nueve);
        //double diez=018CDF; //Este es incorrecto porque utiliza varias terminaciones como "D" que indica double o "F" de float
        long once=0XBC5DA; //Se utiliza long porque es un numero entero entre un rango de 9223372036854775807 y porque es un numero hexadecimal
        System.out.println(once);
        long doze=0x87e3a; //Se utiliza long porque es un numero entero entre un rango de 9223372036854775807 y porque es un numero hexadecimal
        System.out.println(doze);
        long trece=23467L; //Se utiliza long porque es un numero entro entre un rango de 9223372036854775807 y porque se indica "L" en el valor de la variable
        System.out.println(trece);
        //short catorce=0_B11; //Este es incorrecto porque utiliza "_"
        int quince=010101; //Se utiliza int porque son numeros enteros entre un rango de 2147483647
        System.out.println(quince);
        short dieciseis=0_557; //Se utiliza un short porque es un numero entero entre un rango de 32767 y funciona porque java lo interpreta como octal ya que empieza con 0
        System.out.println(dieciseis);
        //double diecisiete=.00.8E2; //Es incorrecto el valor de la variable
        //double dieciocho=.3e3f; //Es incorrecto el valor de la variable
        short diecinueve=0b111; //Se utiliza un short porque es un numero entero entre un rango de 32767 y funciona porque java lo interpreta como octal ya que empieza con 0
        System.out.println(diecinueve);
        long veinte=12_234L; //Se utiliza long porque es un numero entro entre un rango de 9223372036854775807 y porque se indica "L" en el valor de la variable
        System.out.println(veinte);
        long veintiuno=0Xabcd; //Se utiliza long porque es un numero entero entre un rango de 9223372036854775807 y porque es un numero hexadecimal
        System.out.println(veintiuno);
        long veintidos=0xabcEL; //Se utiliza long porque es un numero entero entre un rango de 9223372036854775807 y porque es un numero hexadecimal
        System.out.println(veintidos);
        //short veintitres=_234; //Es incorrecto porque utiiza "_"
        //short veinticuatro=1010B; //Es incorrecto porque utiliza la letra "B"
        long veinticinco=0x1010B; //Se utiliza long porque es un numero entero entre un rango de 9223372036854775807 y porque es un numero hexadecimal
        System.out.println(veinticinco);
        double veintiseis=1_234.2E-2;
        System.out.println(veintiseis);
        //double veintisiete=1234.2EF; //Es incorrecto porque utiliza el valor "E" de manera incorrecta
        double veintiocho=1234.2E3F;
        System.out.println(veintiocho);
        //double veintinueve=1_1.2e_2; //Es incorrecto porque utiliza mal el guionbajo
        //long treinta=0bABCDL; //Es incorrecto porque le falta poner una "x" despues del 0 para que sea hexadecimal
        long treintaiuno=0X1A;
        System.out.println(treintaiuno);
        long treintaidos=0X12AL;
        System.out.println(treintaidos);
        //long treintaitres=abdc; //No es un valor correcto
        short treintaicuatro=0125;
        System.out.println(treintaicuatro);
        double treintaicinco=.01011;
        System.out.println(treintaicinco);
        double treintaiseis=3e12;
        System.out.println(treintaiseis);
        //double treintaisiete=3_e12; //Es incorrecto porque el guionbajo no va entre numeros
        double treintaiocho=-3E-1_2;
        System.out.println(treintaiocho);
        //double treintainueve=0.8E; //Es incorrecto porque el valor "E" no esta concadenado de forma correcta
        //long cuarenta=0B1212; //Es incorrecto porque los valores hexadecimales empiezan por "0x"
        byte cuarentaiuno=1_2_3;
        System.out.println(cuarentaiuno);
        long cuarentaidos=0xedad;
        System.out.println(cuarentaidos);
        long cuarentaitres=0xedad;
        System.out.println(cuarentaitres);
        double cuarentaicuatro=101e2;
        System.out.println(cuarentaicuatro);
        //long cuarentaicinco=B1101; //Es incorrecto porque los valores hexadecimales empiezan por "0X"
        //double cuarentaiseis=1.34.5; //Es incorrecto porque el valor literal es incorrecto (No puede haber varias comas ya dentro de una)
        double cuarentaisiete=12.3E4F;
        System.out.println(cuarentaisiete);
        //long cuarentaiocho=0X12AG; //Es incorrecto porque la letra G excede la cantidad de numero en el hexadecimal

//Ejercicio literales tipo "Char"

        char letra1='a';
        System.out.println(letra1);
        char letra2='$';
        System.out.println(letra2);
        char letra3='\n';
        System.out.println(letra3);
        //char letra4='/n'; //Es incorrecto porque utiliza un caracter constante "/"
        char letra5='\\';
        System.out.println(letra5);
        //char letra6='\ñ'; //Es incorrecto porque es una sequencia no valida
        //char letra7="T"; //Es incorrecto porque deberia ser un string por las dobles comillas
        char letra8='ñ';
        System.out.println(letra8);
        //char letra9='xyz'; //Es incorrecto porque es un caracter constante
        char letra10='\u0066';
        System.out.println(letra10);
        //char letra11='XYZ'; //Es incorrecto oprque es un caracter constante
        char letra12='4';
        System.out.println(letra12);
        char letra13='\t';
        System.out.println(letra13);
        char letra14='\b';
        System.out.println(letra14);
        //char letra15=k; //Es incorrecto porque el caracter tiene que tener comillas
        //char letra16=+; //Es incorrecto porque el caracter tiene que tener comillas
        char letra17='+';
        System.out.println(letra17);
        char letra18='?';
        System.out.println(letra18);
        char letra19='â';
        System.out.println(letra19);
        char letra20=':';
        System.out.println(letra20);

//Ejercicios de strings

        //String str1='8:15 P.M.'; //Es incorrecto porque va con comillas en vez de dobles comillas
        String str2="Rojo, Blanco y Azul";
        System.out.println(str2);
        //String str3="Nombre:; //Es incorrecto porque el valor de la variable debe de acabar con comilla
        //String str4="Capítulo \’3\’"; //Es incorrecto porque el valor utiliza una sequencia incorrecta y utiliza comillas dentro de las dobles comillas
        String str5="1.3e-1-2";
        System.out.println(str5);
        String str6="";
        System.out.println(str6);
        String str7=" ";
        System.out.println(str7);
        String str8="A";
        System.out.println(str8);
        //String str9="FP'; //Es incorrecto porque utiliza diferentes comillas para cerrar el valor
        String str10=" programación ";
        System.out.println(str10);
        //String str11="programación "Java""; //Es incorrecto porque utiliza comillas dentro de otras comillas
        //String str12=programación; //Es incorrecto porque no tiene comillas
        //String str13='W' //Es incorrecto porque utiliza comillas en vez de dobles comillas
        String str14="\n";
        System.out.println(str14);
        String str15="4 + 5 * 2";
        System.out.println(str15);
        
//Declarar variables

    //Variables enteras
        byte q, p;
        q=1;
        p=2;
        System.out.println(q);
        System.out.println(p);
    
    //Variables float
        float x, y, z;
        x=3.5f;
        y=4.5f;
        z=5.5f;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);

    //Variables caracter
        char a, b, c;
        a='r';
        b='i';
        c='o';
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

    //Variables double
        double raiz1, raiz2;
        raiz1=9.5;
        raiz2=10.5;
        System.out.println(raiz1);
        System.out.println(raiz2);
        
    //Variable long
        long contador=897345424;
        System.out.println(contador);

    //Variabl short
        short indicador=4567;
        System.out.println(indicador);

    //Variable entera
        int indice=434567865;
        System.out.println(indice);

    //Variables double
        double precio, preciofinal, IVA;
        precio=100;
        IVA=precio * 0.21;
        preciofinal= precio + IVA;
        System.out.println(precio);
        System.out.println(IVA);
        System.out.println(preciofinal);

    //Variables char
        char car1, car2;
        car1='a';
        car2='b';
        System.out.println(car1);
        System.out.println(car2);

    //Variable tipo byte
        byte valor=123;
        System.out.println(valor);

    //Variables logicas
        boolean primero, ultimo;
        primero=true;
        ultimo=false;
        System.out.println(primero);
        System.out.println(ultimo);

    //Variable tipo string
        String nombre="Francisco Javier Rodríguez";
        System.out.println(nombre);
        
//Declarar variables

        byte edad=18;
        System.out.println(edad);

        short CodigoPostal=07004;
        System.out.println(CodigoPostal);

        float altura=1.70f;
        System.out.println(altura);

        String h, m;
        h="Hombre";
        m="Mujer";
        System.out.println(h);
        System.out.println(m);

        String Nombre="Francisco Javier";
        System.out.println(Nombre);

        byte NumeroHijos=0;
        System.out.println(NumeroHijos);

        float IVA1, Precio1, PrecioFinal1;
        Precio1=49.97f;
        IVA1=Precio1 * 0.21f;
        PrecioFinal1=Precio1 + IVA1;
        System.out.println(Precio1);
        System.out.println(IVA1);
        System.out.println(PrecioFinal1);

        byte TallaCamiseta=36;
        System.out.println(TallaCamiseta);

        float peso=55.4f;
        System.out.println(peso);

        float Precio2=199.99f;
        System.out.println(Precio2);

        boolean alumnoRepetidorno=false, alumnoRepetidorsi=true;
        System.out.println(alumnoRepetidorno);
        System.out.println(alumnoRepetidorsi);

        String mensaje="Hola mañana nos vemos a las 17:30, en el centro";
        System.out.println(mensaje);

        char letra='A';
        System.out.println(letra);
        
        boolean mayorEdad=true;
        System.out.println(mayorEdad);

        byte minutos=60 , dias=7;
        System.out.println(minutos);
        System.out.println(dias);

        String matriculaCoche="1234ABC";
        System.out.println(matriculaCoche);

        int contador1=281823462;
        System.out.println(contador1);

        boolean mayorEdadsi=true, mayorEdadno=false;
        System.out.println(mayorEdadsi);
        System.out.println(mayorEdadno);

        char tallaCamiseta1='S';
        System.out.println(tallaCamiseta1);

//Convertir las expressiones algebraicas en algoritmicas

        byte A, B, C, X, Y, D, Z, E, F, G, H, J, M, N, R, S, Q, P;
        A=2;
        B=3;
        C=6;
        X=6;
        Y=4;
        D=7;
        Z=1;
        E=3;
        F=10;
        G=4;
        H=7;
        J=5;
        M=6;
        N=4;
        R=1;
        S=2;
        Q=13;
        P=8;
        
        int PrimerCalculo=(B/2)-(4*A*C);
        System.out.println(PrimerCalculo);

        int SegundoCalculo=(3*X*Y)-(5*X)+(12*X)-17;
        System.out.println(SegundoCalculo);

        int TercerCalculo=(B+D)/(C+4);
        System.out.println(TercerCalculo);

        int CuartoCalculo=(X*Y)/(Y+2);
        System.out.println(CuartoCalculo);

        int QuintoCalculo=(1/Y)+((3*X)/(Z+1));
        System.out.println(QuintoCalculo);

        int SextoCalculo=(1/Y)+((3+X)/Y);
        System.out.println(SextoCalculo);

        int SeptimoCalculo=(1/Y)+((3+X)/(Y+1));
        System.out.println(SeptimoCalculo);

//mas calculos (Variables declaradas arriba)
        
        int OctavoCalculo=(3/2)+(4/3);
        System.out.println(OctavoCalculo);

        int NovenoCalculo=(1/(X-5))-((3*X*Y)/4);
        System.out.println(NovenoCalculo);

        int DecimoCalculo=(1/2)+7;
        System.out.println(DecimoCalculo);

        int OnceavoCalculo=7+(1/2);
        System.out.println(OnceavoCalculo);

        int DoceavoCalculo=((A*A)/(B-C))+((D-E)/(F-((G*H)/J)));
        System.out.println(DoceavoCalculo);

        int TreceavoCalculo=(M/N)+P;
        System.out.println(TreceavoCalculo);

        int DecimoCuartoCalculo=M+(N/(P-Q));
        System.out.println(DecimoCuartoCalculo);

        int DecimoQuintoCalculo=((A*A)/(B*B))+((C*C)/(D*D));
        System.out.println(DecimoQuintoCalculo);

        int DecimoSextoCalculo=(M+(N/P))/(Q-(R/S));
        System.out.println(DecimoSextoCalculo);

        int DecimoSeptimoCalculo=(3*A+B)/(C-((D+5*E)/(F+(G/(2*H)))));
        System.out.println(DecimoSeptimoCalculo);

        int DecimoOctavoCalculo=((A*A)+(2*A*B)+(B*B))/((1/(X*X))+2);
        System.out.println(DecimoOctavoCalculo);

//Calcula

        int a1, b1, c1;
        a1=8;
        b1=3;
        c1=-5;
        
        int CalculoUno=a1+b1+c1;
        System.out.println(CalculoUno);

        int CalculoDos=(2*b1)+(3*(a1-c1));
        System.out.println(CalculoDos);

        int CalculoTres=a1/b1;
        System.out.println(CalculoTres);

        int CalculoCuatro=a1%b1;
        System.out.println(CalculoCuatro);

        int CalculoCinco=a1/c1;
        System.out.println(CalculoCinco);

        int CalculoSeis=a1%c1;
        System.out.println(CalculoSeis);

        int CalculoSieste=(a1*b1)/c1;
        System.out.println(CalculoSieste);

        int CalculoOcho=a1*(b1/c1);
        System.out.println(CalculoOcho);

        int CalculoNueve=(a1*c1)%b1;
        System.out.println(CalculoNueve);

        int CalculoDiez=a1*(c1%b1);
        System.out.println(CalculoDiez);

        int CalculoOnce=((3*a1)-(2*b1))%((2*a1)-c1);
        System.out.println(CalculoOnce);

        int CalculoDoze=2*(a1/5+(4-(b1*3)))%(a1+c1-2);
        System.out.println(CalculoDoze);

        int CalculoTrece=(a1-(3*b))%(c1+(2*a1))/(a1-c1);
        System.out.println(CalculoTrece);

        int CalculoCatorce=a1-b1-(c1*2);
        System.out.println(CalculoCatorce);

//calcula 2

        double x1, y1, z1;
        x1=88;
        y1=3.5;
        z1=-5.2;

        double Calculo1=x1+y1+z1;
        System.out.println(Calculo1);

        double Calculo2=(2*y1)+(3*(x1-z1));
        System.out.println(Calculo2);

        double Calculo3=x1/y1;
        System.out.println(Calculo3);

        double Calculo4=x1%y1;
        System.out.println(Calculo4);

        double Calculo5=x1/(y1+z1);
        System.out.println(Calculo5);

        double Calculo6=(x1/y1)+z1;
        System.out.println(Calculo6);

        double Calculo7=(2*x1)/(3*y1);
        System.out.println(Calculo7);

        double Calculo8=(2*x1)/(3*y1);
        System.out.println(Calculo8);

        double Calculo9=(x1*y1)%z1;
        System.out.println(Calculo9);

        double Calculo10=x1*(y1%z1);
        System.out.println(Calculo10);

        double Calculo11=(3*x1)-z1-(2*x1);
        System.out.println(Calculo11);

        double Calculo12=((2*x1)/5)%y1;
        System.out.println(Calculo12);

        double Calculo13=x1-((100%y1)%z1);
        System.out.println(Calculo13);

        double Calculo14=x1-y1-(z1*2);
        System.out.println(Calculo14);

//Declarar variables acorde a la operacion y a su resultado

        byte b2=2;
        short s=4;
        long ln=6;
        int i=21, j=40;
        float f=2.3f;
        double d=95.4;
        char c2='a';
        
        //int Op1= i+c2; //Es incorrecto porque no se puede sumar un numero con un caracter
        //float Op2= f-c2; //Es incorrecto, lo mismo que el anterior

        double Op3=d+f;
        System.out.println(Op3);

        double Op4=d+i;
        System.out.println(Op4);

        float Op5=i/f;
        System.out.println(Op5);

        int Op6=s+j;
        System.out.println(Op6);

        double Op7=d+j;
        System.out.println(Op7);

        //short Op8=s*c2; //Es incorrecto, el mismo error que los anteriores
        //double Op9=d+c2; //Es incorrecto, el mismo error que los anteriores
        //byte Op10=b+c2; //Es incorrecto, el mismo error que los anterirores
        //short Op11=b/c2+s; //Es incorrecto, el mismo error que los anteriores
        //int Op12=c2+c2; //Es incorrecto, no se pueden sumar 2 caracteres

        double Op13=i+ln+d;
        System.out.println(Op13);

        //long Op14=ln+c; //Es incorrecto, el mismo error que los anteriores
        
        int Op15=5/j;
        System.out.println(Op15);

        double Op16=5.2/j;
        System.out.println(Op16);

        double Op17=i*f*2.5;
        System.out.println(Op17);

        float Op18=ln*f*2.5f;
        System.out.println(Op18);

        long Op19=j-4L;
        System.out.println(Op19);

        float Op20=j-(4L*2.5f);
        System.out.println(Op20);

        double Op21=b+(2.5*i)+35F;
        System.out.println(Op21);

        //byte Op22='a'+b; //Es incorrecto, el mismo error que los anteriores
        //int Op23='a'+c2; //Es incorrecto, el mismo error que los anteriores
        //int Op24=c2+2; //Es incorrecto, el mismo error que los anteriores
        //int Op25=c-ln/2; //Es incorrecto, el mismo error que los anteriores

        double Op26=(2/i)+(2.0/j);
        System.out.println(Op26);

//Calcula operaciones logicas

        boolean x2,y2,z2;
        x2=true;
        y2=false;
        z2=true;

        boolean OpL1=(x2 && y2) || (x2 && z2);
        System.out.println(OpL1);
        boolean OpL2=(x2 || !y2)&& (!x2 || z2);
        System.out.println(OpL2);
        boolean OpL3=x2 || y2 && z2;
        System.out.println(OpL3);
        boolean OpL4=!(x2 || y2) && z2;
        System.out.println(OpL4);
        boolean OpL5=x2 || y2 || x2 && !z2 && !y2;
        System.out.println(OpL5);
        boolean OpL6=!x2 || !y2 || z2 && x2 && !y2;
        System.out.println(OpL6);

//Calcula Operaciones logicas2

        boolean w3,y3,x3,z3;
        w3=false;
        y3=true;
        x3=true;
        z3=false;

        boolean Opl1=w3 || y3 && x3 && w3 || z3;
        System.out.println(Opl1);
        boolean Opl2=x3 && !y3 && !x3 || !w3 && y3;
        System.out.println(Opl2);
        boolean Opl3=!(w3 || !y3) && x3 || z3;
        System.out.println(Opl3);
        boolean Opl4=x3 && y3 && w3 || z3 || x3;
        System.out.println(Opl4);
        boolean Opl5=y3 || !(y3 || z3 && w3);
        System.out.println(Opl5);
        boolean Opl6=!x3 && y3 && (!z3 || !x3);
        System.out.println(Opl6);
        
    }
}