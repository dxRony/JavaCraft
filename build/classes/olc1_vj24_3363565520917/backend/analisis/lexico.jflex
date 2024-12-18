
package olc1_vj24_3363565520917.backend.analisis;

//importaciones
import java_cup.runtime.Symbol;
import java.util.LinkedList;
import olc1_vj24_3363565520917.backend.excepciones.Errores;

%%

//definicion de variables

%{
    String cadena = "";
    public LinkedList<Errores> listaErrores = new LinkedList<>();
%}

//definiciones iniciales, linea y columna donde se inicia

%init{
    yyline = 1;
    yycolumn = 1;
    listaErrores = new LinkedList<>();
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

//signos de agrupacion
PAR1 = "("
PAR2 = ")"
LLAVE1 = "{"
LLAVE2 = "}"
CORCH1 = "["
CORCH2 = "]"
FININSTRUCCION = ";"
DOSPUNTOS = ":"
PUNTO = "."
COMA = ","
BLANCOS = [\ \r\t\n\f]+
ENTERO = [0-9]+
DECIMAL = [0-9]+"."[0-9]+
CADENA = [\"]([^\"])*[\"]
CARACTER = [\']([^\']){1}[\']
BOOLEANO = "true"|"false"
MUTABILIDAD = "var"|"const"
ID = [A-Za-z]+[0-9]*

//comentarios
COMENTARIOLINEA = "//"[^\n]*
COMENTARIOMULTILINEA = "/*"(.|[\r\n])*"*/"

//operadores aritmeticos
MAS = "+"
MENOS = "-"
MULTIPLICAR = "*"
DIVIDIR = "/"
POTENCIA = "**"
MODULO = "%"

//operadores relacionales
IGUAL = "="
IGUALACION = "=="
DIFERENCIACION = "!="
MENORQUE = "<"
MENORIGUALQUE = "<="
MAYORQUE = ">"
MAYORIGUALQUE = ">="

//operadores logicos
OR = "||"
AND = "&&"
XOR = "^"
NOT = "!"

//incremento/decremento
INCREMENTO = "++"
DECREMENTO = "--"
DEFAULT = "_"

//palabras reservadas
IMPRIMIR = "println"
INT = "int"
DOUBLE = "double"
BOOL = "bool"
CHAR = "char"
STRING = "string"
IF = "if"
ELSE = "else"
MATCH = "match"
WHILE = "while"
FOR = "for"
DO = "do"
BREAK = "break"
CONTINUE = "continue"
LIST = "list"
NEW = "new"
APPEND = "append"
REMOVE = "remove"
STRUCT = "struct"
RETURN = "return"
VOID = "void"
ROUND = "round"
LENGTH = "length"
TOSTRING = "toString"
FIND = "Find"
STARTWITH = "start_with"

%%
//palabras reservadas
<YYINITIAL> {IMPRIMIR}        {return new Symbol(sym.IMPRIMIR, yyline, yycolumn, yytext());    }
<YYINITIAL> {INT}             {return new Symbol(sym.INT, yyline, yycolumn, yytext());         }
<YYINITIAL> {DOUBLE}          {return new Symbol(sym.DOUBLE, yyline, yycolumn, yytext());      }
<YYINITIAL> {BOOL}            {return new Symbol(sym.BOOL, yyline, yycolumn, yytext());        }
<YYINITIAL> {CHAR}            {return new Symbol(sym.CHAR, yyline, yycolumn, yytext());        }
<YYINITIAL> {STRING}          {return new Symbol(sym.STRING, yyline, yycolumn, yytext());      }
<YYINITIAL> {IF}              {return new Symbol(sym.IF, yyline, yycolumn, yytext());          }
<YYINITIAL> {ELSE}            {return new Symbol(sym.ELSE, yyline, yycolumn, yytext());        }
<YYINITIAL> {MATCH}           {return new Symbol(sym.MATCH, yyline, yycolumn, yytext());       }
<YYINITIAL> {WHILE}           {return new Symbol(sym.WHILE, yyline, yycolumn, yytext());       }
<YYINITIAL> {FOR}             {return new Symbol(sym.FOR, yyline, yycolumn, yytext());         }
<YYINITIAL> {DO}              {return new Symbol(sym.DO, yyline, yycolumn, yytext());          }
<YYINITIAL> {BREAK}           {return new Symbol(sym.BREAK, yyline, yycolumn, yytext());       }
<YYINITIAL> {CONTINUE}        {return new Symbol(sym.CONTINUE, yyline, yycolumn, yytext());    }
<YYINITIAL> {BOOLEANO}        {return new Symbol(sym.BOOLEANO, yyline, yycolumn, yytext());    }
<YYINITIAL> {MUTABILIDAD}     {return new Symbol(sym.MUTABILIDAD, yyline, yycolumn, yytext()); }
<YYINITIAL> {LIST}            {return new Symbol(sym.LIST, yyline, yycolumn, yytext());        }
<YYINITIAL> {NEW}             {return new Symbol(sym.NEW, yyline, yycolumn, yytext());         }
<YYINITIAL> {APPEND}          {return new Symbol(sym.APPEND, yyline, yycolumn, yytext());      }
<YYINITIAL> {REMOVE}          {return new Symbol(sym.REMOVE, yyline, yycolumn, yytext());      }
<YYINITIAL> {STRUCT}          {return new Symbol(sym.STRUCT, yyline, yycolumn, yytext());      }
<YYINITIAL> {RETURN}          {return new Symbol(sym.RETURN, yyline, yycolumn, yytext());      }
<YYINITIAL> {VOID}            {return new Symbol(sym.VOID, yyline, yycolumn, yytext());        }
<YYINITIAL> {ROUND}           {return new Symbol(sym.ROUND, yyline, yycolumn, yytext());       }
<YYINITIAL> {LENGTH}          {return new Symbol(sym.LENGTH, yyline, yycolumn, yytext());      }
<YYINITIAL> {TOSTRING}        {return new Symbol(sym.TOSTRING, yyline, yycolumn, yytext());    }
<YYINITIAL> {FIND}            {return new Symbol(sym.FIND, yyline, yycolumn, yytext());        }
<YYINITIAL> {STARTWITH}       {return new Symbol(sym.STARTWITH, yyline, yycolumn, yytext());   }



//simbolos del sistema
<YYINITIAL> {COMENTARIOLINEA}       {}
<YYINITIAL> {COMENTARIOMULTILINEA}  {}
<YYINITIAL> {BLANCOS}               {}
<YYINITIAL> {ID}                    {return new Symbol(sym.ID, yyline, yycolumn, yytext());         }
<YYINITIAL> {DECIMAL}               {return new Symbol(sym.DECIMAL, yyline, yycolumn, yytext());    }
<YYINITIAL> {ENTERO}                {return new Symbol(sym.ENTERO, yyline, yycolumn, yytext());     }
<YYINITIAL> {CADENA}                {
    String cadena = yytext();
    cadena = cadena.substring(1, cadena.length()-1);//quita las comillas de inicio y las del final: "asdasd" -> asdasd
    cadena = cadena.replace("\\n", "\n").replace("\\t", "\t").replace("\\\"", "\"").replace("\\'", "'").replace("\\\\", "\\");//reemplazando las secuencias de escape con secuencias de escape de java
    return new Symbol(sym.CADENA, yyline, yycolumn, cadena);                                        }
<YYINITIAL> {CARACTER}              {
    String caracter = yytext();
    caracter = caracter.substring(1, caracter.length()-1);
    return new Symbol(sym.CARACTER, yyline, yycolumn, caracter);                                    }
<YYINITIAL> {FININSTRUCCION}  {return new Symbol(sym.FININSTRUCCION, yyline, yycolumn, yytext());   }
<YYINITIAL> {PUNTO}           {return new Symbol(sym.PUNTO, yyline, yycolumn, yytext());            }
<YYINITIAL> {COMA}            {return new Symbol(sym.COMA, yyline, yycolumn, yytext());             }
<YYINITIAL> {DOSPUNTOS}       {return new Symbol(sym.DOSPUNTOS, yyline, yycolumn, yytext());        }
<YYINITIAL> {IGUALACION}      {return new Symbol(sym.IGUALACION, yyline, yycolumn, yytext());       }
<YYINITIAL> {POTENCIA}        {return new Symbol(sym.POTENCIA, yyline, yycolumn, yytext());         }
<YYINITIAL> {DIFERENCIACION}  {return new Symbol(sym.DIFERENCIACION, yyline, yycolumn, yytext());   }
<YYINITIAL> {MENORIGUALQUE}   {return new Symbol(sym.MENORIGUALQUE, yyline, yycolumn, yytext());    }
<YYINITIAL> {MAYORIGUALQUE}   {return new Symbol(sym.MAYORIGUALQUE, yyline, yycolumn, yytext());    }
<YYINITIAL> {OR}              {return new Symbol(sym.OR, yyline, yycolumn, yytext());               }
<YYINITIAL> {AND}             {return new Symbol(sym.AND, yyline, yycolumn, yytext());              }
<YYINITIAL> {XOR}             {return new Symbol(sym.XOR, yyline, yycolumn, yytext());         }
<YYINITIAL> {NOT}             {return new Symbol(sym.NOT, yyline, yycolumn, yytext());              }
<YYINITIAL> {INCREMENTO}      {return new Symbol(sym.INCREMENTO, yyline, yycolumn, yytext());       }
<YYINITIAL> {DECREMENTO}      {return new Symbol(sym.DECREMENTO, yyline, yycolumn, yytext());       }
<YYINITIAL> {IGUAL}           {return new Symbol(sym.IGUAL, yyline, yycolumn, yytext());            }
<YYINITIAL> {MAS}             {return new Symbol(sym.MAS, yyline, yycolumn, yytext());              }
<YYINITIAL> {MENOS}           {return new Symbol(sym.MENOS, yyline, yycolumn, yytext());            }
<YYINITIAL> {MULTIPLICAR}     {return new Symbol(sym.MULTIPLICAR, yyline, yycolumn, yytext());      }
<YYINITIAL> {DIVIDIR}         {return new Symbol(sym.DIVIDIR, yyline, yycolumn, yytext());          }
<YYINITIAL> {MODULO}          {return new Symbol(sym.MODULO, yyline, yycolumn, yytext());           }
<YYINITIAL> {DEFAULT}         {return new Symbol(sym.DEFAULT, yyline, yycolumn, yytext());     }
<YYINITIAL> {MENORQUE}        {return new Symbol(sym.MENORQUE, yyline, yycolumn, yytext());         }
<YYINITIAL> {MAYORQUE}        {return new Symbol(sym.MAYORQUE, yyline, yycolumn, yytext());         }
<YYINITIAL> {PAR1}            {return new Symbol(sym.PAR1, yyline, yycolumn, yytext());             }
<YYINITIAL> {PAR2}            {return new Symbol(sym.PAR2, yyline, yycolumn, yytext());             }
<YYINITIAL> {LLAVE1}          {return new Symbol(sym.LLAVE1, yyline, yycolumn, yytext());           }
<YYINITIAL> {LLAVE2}          {return new Symbol(sym.LLAVE2, yyline, yycolumn, yytext());           }
<YYINITIAL> {CORCH1}          {return new Symbol(sym.CORCH1, yyline, yycolumn, yytext());      }
<YYINITIAL> {CORCH2}          {return new Symbol(sym.CORCH2, yyline, yycolumn, yytext());      }

<YYINITIAL> . {listaErrores.add(new Errores("LEXICO", "No se esperaba el caracter: " +yytext(), yyline, yycolumn));}