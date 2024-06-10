
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package olc1_vj24_3363565520917.backend.analisis;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import olc1_vj24_3363565520917.backend.abstracto.Instruccion;
import olc1_vj24_3363565520917.backend.simbolo.Tipo;
import olc1_vj24_3363565520917.backend.simbolo.tipoDato;
import olc1_vj24_3363565520917.backend.instrucciones.Print;
import olc1_vj24_3363565520917.backend.expresiones.Nativo;
import olc1_vj24_3363565520917.backend.expresiones.Aritmeticas;
import olc1_vj24_3363565520917.backend.expresiones.Relacionales;
import olc1_vj24_3363565520917.backend.expresiones.Logicos;
import olc1_vj24_3363565520917.backend.expresiones.OperadoresAritmeticos;
import olc1_vj24_3363565520917.backend.expresiones.OperadoresRelacionales;
import olc1_vj24_3363565520917.backend.expresiones.OperadoresLogicos;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\033\000\002\002\004\000\002\002\003\000\002\003" +
    "\004\000\002\003\003\000\002\004\007\000\002\005\004" +
    "\000\002\005\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\005\000\002\005\005\000\002\005\005\000\002" +
    "\005\005\000\002\005\005\000\002\005\005\000\002\005" +
    "\005\000\002\005\005\000\002\005\005\000\002\005\004" +
    "\000\002\005\005\000\002\005\005\000\002\005\005\000" +
    "\002\005\003\000\002\005\003\000\002\005\003\000\002" +
    "\005\003\000\002\005\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\004\012\006\001\002\000\006\002\ufffe\012" +
    "\ufffe\001\002\000\006\002\000\012\006\001\002\000\004" +
    "\017\011\001\002\000\004\002\010\001\002\000\004\002" +
    "\001\001\002\000\020\004\020\005\017\006\016\007\015" +
    "\010\021\014\014\050\012\001\002\000\020\004\020\005" +
    "\017\006\016\007\015\010\021\014\014\050\012\001\002" +
    "\000\042\013\034\014\025\015\033\016\036\020\061\040" +
    "\040\041\026\042\027\043\035\044\030\045\041\046\023" +
    "\047\024\054\037\056\031\057\032\001\002\000\020\004" +
    "\020\005\017\006\016\007\015\010\021\014\014\050\012" +
    "\001\002\000\042\013\uffe8\014\uffe8\015\uffe8\016\uffe8\020" +
    "\uffe8\040\uffe8\041\uffe8\042\uffe8\043\uffe8\044\uffe8\045\uffe8" +
    "\046\uffe8\047\uffe8\054\uffe8\056\uffe8\057\uffe8\001\002\000" +
    "\042\013\uffea\014\uffea\015\uffea\016\uffea\020\uffea\040\uffea" +
    "\041\uffea\042\uffea\043\uffea\044\uffea\045\uffea\046\uffea\047" +
    "\uffea\054\uffea\056\uffea\057\uffea\001\002\000\042\013\uffeb" +
    "\014\uffeb\015\uffeb\016\uffeb\020\uffeb\040\uffeb\041\uffeb\042" +
    "\uffeb\043\uffeb\044\uffeb\045\uffeb\046\uffeb\047\uffeb\054\uffeb" +
    "\056\uffeb\057\uffeb\001\002\000\042\013\uffe9\014\uffe9\015" +
    "\uffe9\016\uffe9\020\uffe9\040\uffe9\041\uffe9\042\uffe9\043\uffe9" +
    "\044\uffe9\045\uffe9\046\uffe9\047\uffe9\054\uffe9\056\uffe9\057" +
    "\uffe9\001\002\000\042\013\uffe7\014\uffe7\015\uffe7\016\uffe7" +
    "\020\uffe7\040\uffe7\041\uffe7\042\uffe7\043\uffe7\044\uffe7\045" +
    "\uffe7\046\uffe7\047\uffe7\054\uffe7\056\uffe7\057\uffe7\001\002" +
    "\000\042\013\ufffc\014\ufffc\015\ufffc\016\ufffc\020\ufffc\040" +
    "\ufffc\041\ufffc\042\ufffc\043\ufffc\044\ufffc\045\ufffc\046\ufffc" +
    "\047\ufffc\054\ufffc\056\ufffc\057\ufffc\001\002\000\020\004" +
    "\020\005\017\006\016\007\015\010\021\014\014\050\012" +
    "\001\002\000\020\004\020\005\017\006\016\007\015\010" +
    "\021\014\014\050\012\001\002\000\020\004\020\005\017" +
    "\006\016\007\015\010\021\014\014\050\012\001\002\000" +
    "\020\004\020\005\017\006\016\007\015\010\021\014\014" +
    "\050\012\001\002\000\020\004\020\005\017\006\016\007" +
    "\015\010\021\014\014\050\012\001\002\000\020\004\020" +
    "\005\017\006\016\007\015\010\021\014\014\050\012\001" +
    "\002\000\020\004\020\005\017\006\016\007\015\010\021" +
    "\014\014\050\012\001\002\000\020\004\020\005\017\006" +
    "\016\007\015\010\021\014\014\050\012\001\002\000\020" +
    "\004\020\005\017\006\016\007\015\010\021\014\014\050" +
    "\012\001\002\000\020\004\020\005\017\006\016\007\015" +
    "\010\021\014\014\050\012\001\002\000\020\004\020\005" +
    "\017\006\016\007\015\010\021\014\014\050\012\001\002" +
    "\000\020\004\020\005\017\006\016\007\015\010\021\014" +
    "\014\050\012\001\002\000\020\004\020\005\017\006\016" +
    "\007\015\010\021\014\014\050\012\001\002\000\020\004" +
    "\020\005\017\006\016\007\015\010\021\014\014\050\012" +
    "\001\002\000\020\004\020\005\017\006\016\007\015\010" +
    "\021\014\014\050\012\001\002\000\042\013\034\014\025" +
    "\015\033\016\036\020\uffee\040\040\041\026\042\027\043" +
    "\035\044\030\045\uffee\046\023\047\024\054\037\056\031" +
    "\057\032\001\002\000\042\013\034\014\025\015\033\016" +
    "\036\020\ufff5\040\ufff5\041\026\042\ufff5\043\ufff5\044\ufff5" +
    "\045\ufff5\046\ufff5\047\ufff5\054\037\056\ufff5\057\ufff5\001" +
    "\002\000\042\013\ufff6\014\ufff6\015\ufff6\016\ufff6\020\ufff6" +
    "\040\ufff6\041\026\042\ufff6\043\ufff6\044\ufff6\045\ufff6\046" +
    "\ufff6\047\ufff6\054\ufff6\056\ufff6\057\ufff6\001\002\000\042" +
    "\013\ufff8\014\ufff8\015\ufff8\016\ufff8\020\ufff8\040\ufff8\041" +
    "\026\042\ufff8\043\ufff8\044\ufff8\045\ufff8\046\ufff8\047\ufff8" +
    "\054\ufff8\056\ufff8\057\ufff8\001\002\000\042\013\034\014" +
    "\025\015\033\016\036\020\ufff2\040\ufff2\041\026\042\ufff2" +
    "\043\ufff2\044\ufff2\045\ufff2\046\ufff2\047\ufff2\054\037\056" +
    "\ufff2\057\ufff2\001\002\000\042\013\ufffb\014\ufffb\015\033" +
    "\016\036\020\ufffb\040\ufffb\041\026\042\ufffb\043\ufffb\044" +
    "\ufffb\045\ufffb\046\ufffb\047\ufffb\054\037\056\ufffb\057\ufffb" +
    "\001\002\000\042\013\ufff9\014\ufff9\015\ufff9\016\ufff9\020" +
    "\ufff9\040\ufff9\041\026\042\ufff9\043\ufff9\044\ufff9\045\ufff9" +
    "\046\ufff9\047\ufff9\054\ufff9\056\ufff9\057\ufff9\001\002\000" +
    "\042\013\034\014\025\015\033\016\036\020\ufff1\040\ufff1" +
    "\041\026\042\ufff1\043\ufff1\044\ufff1\045\ufff1\046\ufff1\047" +
    "\ufff1\054\037\056\ufff1\057\ufff1\001\002\000\042\013\034" +
    "\014\025\015\033\016\036\020\ufff3\040\ufff3\041\026\042" +
    "\ufff3\043\ufff3\044\ufff3\045\ufff3\046\ufff3\047\ufff3\054\037" +
    "\056\ufff3\057\ufff3\001\002\000\042\013\034\014\025\015" +
    "\033\016\036\020\ufff0\040\ufff0\041\026\042\ufff0\043\ufff0" +
    "\044\ufff0\045\ufff0\046\ufff0\047\ufff0\054\037\056\ufff0\057" +
    "\ufff0\001\002\000\042\013\034\014\025\015\033\016\036" +
    "\020\ufff4\040\ufff4\041\026\042\ufff4\043\ufff4\044\ufff4\045" +
    "\ufff4\046\ufff4\047\ufff4\054\037\056\ufff4\057\ufff4\001\002" +
    "\000\042\013\ufff7\014\ufff7\015\ufff7\016\ufff7\020\ufff7\040" +
    "\ufff7\041\ufff7\042\ufff7\043\ufff7\044\ufff7\045\ufff7\046\ufff7" +
    "\047\ufff7\054\ufff7\056\ufff7\057\ufff7\001\002\000\042\013" +
    "\ufffa\014\ufffa\015\033\016\036\020\ufffa\040\ufffa\041\026" +
    "\042\ufffa\043\ufffa\044\ufffa\045\ufffa\046\ufffa\047\ufffa\054" +
    "\037\056\ufffa\057\ufffa\001\002\000\042\013\034\014\025" +
    "\015\033\016\036\020\uffec\040\040\041\026\042\027\043" +
    "\035\044\030\045\uffec\046\uffec\047\uffec\054\037\056\031" +
    "\057\032\001\002\000\042\013\034\014\025\015\033\016" +
    "\036\020\uffed\040\040\041\026\042\027\043\035\044\030" +
    "\045\uffed\046\uffed\047\024\054\037\056\031\057\032\001" +
    "\002\000\004\011\062\001\002\000\006\002\ufffd\012\ufffd" +
    "\001\002\000\042\013\034\014\025\015\033\016\036\020" +
    "\uffef\040\040\041\026\042\027\043\035\044\030\045\uffef" +
    "\046\uffef\047\uffef\054\037\056\031\057\032\001\002\000" +
    "\006\002\uffff\012\uffff\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\062\000\010\002\006\003\004\004\003\001\001\000" +
    "\002\001\001\000\004\004\063\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\004\005\012\001" +
    "\001\000\004\005\062\001\001\000\002\001\001\000\004" +
    "\005\021\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\057\001\001\000\004\005\056\001" +
    "\001\000\004\005\055\001\001\000\004\005\054\001\001" +
    "\000\004\005\053\001\001\000\004\005\052\001\001\000" +
    "\004\005\051\001\001\000\004\005\050\001\001\000\004" +
    "\005\047\001\001\000\004\005\046\001\001\000\004\005" +
    "\045\001\001\000\004\005\044\001\001\000\004\005\043" +
    "\001\001\000\004\005\042\001\001\000\004\005\041\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    scanner s;
    parser(scanner s) {this.s = s;}
    
    public void syntax_error(Symbol s){
        System.out.println("Error Sintactico en la linea " + 
        (s.left) + " y columna " + (s.right) +
        ". No se esperaba el componente: " + (s.value) + ".");
    }

    public void unrecovered_syntax_error(Symbol s ){
        System.out.println("Error Sintactico no recuperable en la linea" +
        (s.left) + " y columna " + (s.right) +
        ". No se esperaba el componente: " + (s.value) + ".");
    }


/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {

   
    //String codigoUsr = "";                                              //aca se guarda el codigo del usuario


  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> start_val = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= INSTRUCCIONES 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		      RESULT=a;      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INSTRUCCIONES ::= INSTRUCCIONES INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		LinkedList<Instruccion> a = (LinkedList<Instruccion>)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT= a; RESULT.add(b);                    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // INSTRUCCIONES ::= INSTRUCCION 
            {
              LinkedList<Instruccion> RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new LinkedList<>(); RESULT.add(a);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCIONES",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // INSTRUCCION ::= IMPRIMIR PAR1 EXPRESION PAR2 FININSTRUCCION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 RESULT = new Print(aleft, aright, a); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INSTRUCCION",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // EXPRESION ::= MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, OperadoresAritmeticos.NEGACION, a);             
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // EXPRESION ::= EXPRESION MAS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.SUMA);              
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // EXPRESION ::= EXPRESION MENOS EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.RESTA);             
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // EXPRESION ::= EXPRESION MULTIPLICAR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.MULTIPLICACION);    
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // EXPRESION ::= EXPRESION DIVIDIR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.DIVISION);          
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // EXPRESION ::= EXPRESION POTENCIA EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.POTENCIA);          
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // EXPRESION ::= EXPRESION MODULO EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Aritmeticas(aleft, aright, a, b, OperadoresAritmeticos.MODULO);            
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // EXPRESION ::= EXPRESION IGUALACION EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.IGUALACION);      
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // EXPRESION ::= EXPRESION DIFERENCIACION EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.DIFERENCIACION);  
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // EXPRESION ::= EXPRESION MENORQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.MENORQUE);        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // EXPRESION ::= EXPRESION MENORIGUALQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.MENORIGUALQUE);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // EXPRESION ::= EXPRESION MAYORQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.MAYORQUE);        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // EXPRESION ::= EXPRESION MAYORIGUALQUE EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Relacionales(aleft, aright, a, b, OperadoresRelacionales.MAYORIGUALQUE);   
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // EXPRESION ::= NOT EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Logicos(aleft, aright, OperadoresLogicos.NOT, a);                          
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // EXPRESION ::= EXPRESION OR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Logicos(aleft, aright, a, b, OperadoresLogicos.OR);                        
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // EXPRESION ::= EXPRESION AND EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Logicos(aleft, aright, a, b, OperadoresLogicos.AND);                       
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // EXPRESION ::= EXPRESION XOR EXPRESION 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Instruccion a = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int bleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int bright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Instruccion b = (Instruccion)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Logicos(aleft, aright, a, b, OperadoresLogicos.XOR);                       
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // EXPRESION ::= ENTERO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nativo(new Tipo(tipoDato.ENTERO), aleft, aright, Integer.parseInt(a));           
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // EXPRESION ::= DECIMAL 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nativo(new Tipo(tipoDato.DECIMAL), aleft, aright, new Double(a));                
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // EXPRESION ::= CADENA 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nativo(new Tipo(tipoDato.CADENA), aleft, aright, a);                             
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // EXPRESION ::= CARACTER 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nativo(new Tipo(tipoDato.CARACTER), aleft, aright, a);                           
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // EXPRESION ::= BOOLEANO 
            {
              Instruccion RESULT =null;
		int aleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int aright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String a = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		  RESULT = new Nativo(new Tipo(tipoDato.BOOLEANO), aleft, aright, a);                           
              CUP$parser$result = parser.getSymbolFactory().newSymbol("EXPRESION",3, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
