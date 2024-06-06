package olc1_vj24_3363565520917.backend.analisis;

//importaciones
import java_cup.runtime.Symbol;

%%

//definicion de variables

%{
    String cadena = "";

%}

//definiciones iniciales, linea y columna donde se inicia

%init{
    yyline = 1;
    yycolumn = 1;
%init}

//declaraciones caracteristicas de jflex
%cup
%class scanner //nombre de la clase (del analizador lexico)
%public //accseso de la clase
%line //lineas
%column //columnas
%char //caracteres
%full
//%debug
%ignorecase //case insensitive

//estados ? (pendiente de cambio)
%state CADENA

//definiendo los simbolos del sistema
PARI = "("
PARD = ")"
FINCADENA = ";"
MAS = "+"
MENOS = "-"
MULTI = "*"
DIV = "/"
BLANCOS = [\ \r\t\n\f]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+

//palabras reservadas
IMPRIMIR = "imprimir"

%%

<YYINITIAL> {IMPRIMIR}  {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());} //<YYINITIAL> = estado inicial, {IMPRIMIR} = patron a reconocer
<YYINITIAL> {DECIMAL}   {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());}    //return new Symbol = devuelve un nuevo simbolo
<YYINITIAL> {ENTERO}    {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());}      //sym.IMPRIMIR = token que corresponde al patron reconocido
<YYINITIAL> {FINCADENA} {return new Symbol(sym.FINCADENA, yyline, yycolumn, yytext());}//yyline = linea donde se encuentra
<YYINITIAL> {MAS}       {return new Symbol(sym.MAS, yyline, yycolumn, yytext());}            //yycolumn = columna donde se encuentra
<YYINITIAL> {MENOS}     {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());}        //yytext() = texto que coincide con el patron del token
<YYINITIAL> {MULTI}     {return new Symbol(sym.MULTI, yyline, yycolumn, yytext());}
<YYINITIAL> {DIV}       {return new Symbol(sym.DIV, yyline, yycolumn, yytext());}
<YYINITIAL> {PARI}      {return new Symbol(sym.PARI, yyline, yycolumn, yytext());}
<YYINITIAL> {PARD}      {return new Symbol(sym.PARD, yyline, yycolumn, yytext());}
<YYINITIAL> {BLANCOS}   {}

//cadena como estado (pendiente de cambio como expresion regular)
<YYINITIAL> [\"]        {cadena = ""; yybegin(CADENA);} //YYINTIAl = estado iniicial del lexer, [\"] = patron que coincide con comilla doble "
                                                        //cadena = "" = incializa variable cadena, donde se guardara el contenido de la cadena    
                                                        //yybegin(CADENA) = cambia el estado del lexer, para procesar una cadena

<CADENA> {                                                          //<CADENA> = indica las reglas que se aplican cuando el lexer esta en el estado cadena                         
    [\"]    {String tmp= cadena;                                    //[\"] = patron que coincide con una comilla doble, String tmp = cadena; = crea un String tmp y guarda el contenido de cadena
            cadena="";                                              //cadena = ""; = limpia la variable cadena 
            yybegin(YYINITIAL);                                     //cambia el estado del lexer a inicial, indicando que la cadena ha terminado
            return new Symbol(sym.CADENA, yyline, yycolumn,tmp);}
    
    [^\"]   {cadena+=yytext();}                                     //si viene cualquier otra cosa que no sea comilla doble, lo agrega a la cadena
}

