//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at 2012-12-07 by the VDM++ to JAVA Code Generator
// (v8.1.1b - Thu 30-Oct-2008 14:59:38)
//
// Supported compilers: jdk 1.4/1.5/1.6
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.jdk.*;
// ***** VDMTOOLS END Name=imports



public class Game implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=board KEEP=NO
  private volatile Board board = null;
// ***** VDMTOOLS END Name=board

// ***** VDMTOOLS START Name=players KEEP=NO
  private volatile HashSet players = new HashSet();
// ***** VDMTOOLS END Name=players

// ***** VDMTOOLS START Name=currentPlayer KEEP=NO
  private volatile Player currentPlayer = null;
// ***** VDMTOOLS END Name=currentPlayer

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=GameSentinel KEEP=NO
  class GameSentinel extends Sentinel {

    public final int init = 0;

    public final int play = 1;

    public final int canPlay = 2;

    public final int passTurn = 3;

    public final int flipPiece = 4;

    public final int pieceFits = 5;

    public final int resetGame = 6;

    public final int validMove = 7;

    public final int isGameOver = 8;

    public final int validNames = 9;

    public final int rotatePiece = 10;

    public final int getPlayerSet = 11;

    public final int getCurrentPlayer = 12;

    public final int getPlayerByColor = 13;

    public final int getNextPlayerToPlay = 14;

    public final int nr_functions = 15;


    public GameSentinel () throws CGException {}


    public GameSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=GameSentinel
;

// ***** VDMTOOLS START Name=evaluatePP#1|int KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP#1|int


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new GameSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=vdm_init_Game KEEP=NO
  private void vdm_init_Game () throws CGException {
    try {

      setSentinel();
      board = (Board) new Board();
      players = new HashSet();
      currentPlayer = null;
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=vdm_init_Game


// ***** VDMTOOLS START Name=Game KEEP=NO
  public Game () throws CGException {
    vdm_init_Game();
  }
// ***** VDMTOOLS END Name=Game


// ***** VDMTOOLS START Name=getPlayerSet KEEP=NO
  public HashSet getPlayerSet () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getPlayerSet);
    try {
      return players;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getPlayerSet);
    }
  }
// ***** VDMTOOLS END Name=getPlayerSet


// ***** VDMTOOLS START Name=getCurrentPlayer KEEP=NO
  public Player getCurrentPlayer () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getCurrentPlayer);
    try {
      return (Player) currentPlayer;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getCurrentPlayer);
    }
  }
// ***** VDMTOOLS END Name=getCurrentPlayer


// ***** VDMTOOLS START Name=init#1|Vector KEEP=NO
  public void init (final Vector names) throws CGException {

    if (!this.pre_init(names).booleanValue()) 
      UTIL.RunTime("Run-Time Error:Precondition failure in init");
    sentinel.entering(((GameSentinel) sentinel).init);
    try {

      Integer i = new Integer(1);
      while ( new Boolean((i.intValue()) <= (new Integer(names.size()).intValue())).booleanValue()){

        Player p1 = null;
        Object c = null;
        boolean succ_6 = true;
        {

          succ_6 = true;
          if (!UTIL.equals(i, new Integer(1))) 
            succ_6 = false;
          if (succ_6) 
            c = UTIL.clone(new quotes.BLUE());
          else {

            succ_6 = true;
            if (!UTIL.equals(i, new Integer(2))) 
              succ_6 = false;
            if (succ_6) 
              c = UTIL.clone(new quotes.YELLOW());
            else {

              succ_6 = true;
              if (!UTIL.equals(i, new Integer(3))) 
                succ_6 = false;
              if (succ_6) 
                c = UTIL.clone(new quotes.RED());
              else {

                succ_6 = true;
                if (!UTIL.equals(i, new Integer(4))) 
                  succ_6 = false;
                if (succ_6) 
                  c = UTIL.clone(new quotes.GREEN());
                else 
                  c = UTIL.clone(new quotes.NONE());
              }
            }
          }
        }
        Player rhs_18 = null;
        String arg_19 = null;
        if ((1 <= i.intValue()) && (i.intValue() <= names.size())) 
          arg_19 = UTIL.ConvertToString(names.get(i.intValue() - 1));
        else 
          UTIL.RunTime("Run-Time Error:Illegal index");
        rhs_18 = new Player(arg_19, c);
        p1 = (Player) UTIL.clone(rhs_18);
        if (new Boolean(UTIL.equals(players, new HashSet())).booleanValue()) {

          p1.toggleIsPlaying();
          currentPlayer = (Player) UTIL.clone(p1);
        }
        players.add(p1);
        i = UTIL.NumberToInt(UTIL.clone(new Integer(i.intValue() + new Integer(1).intValue())));
      }
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).init);
    }
  }
// ***** VDMTOOLS END Name=init#1|Vector


// ***** VDMTOOLS START Name=pre_init#1|Vector KEEP=NO
  public Boolean pre_init (final Vector names) throws CGException {

    Boolean varRes_2 = null;
    {
      if ((varRes_2 = new Boolean(new Integer(names.size()).intValue() == new Integer(4).intValue())).booleanValue()) 
        varRes_2 = validNames(names);
    }
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_init#1|Vector


// ***** VDMTOOLS START Name=validNames#1|Vector KEEP=NO
  public Boolean validNames (final Vector names) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).validNames);
    try {

      Boolean rexpr_2 = null;
      Integer var1_3 = null;
      String unArg_4 = null;
      String rdcseq_6 = new String();
      for (Iterator enm_9 = names.iterator(); enm_9.hasNext(); ) {

        String e_7 = UTIL.ConvertToString(enm_9.next());
        rdcseq_6 = rdcseq_6.concat(e_7);
      }
      unArg_4 = rdcseq_6;
      var1_3 = new Integer(unArg_4.length());
      rexpr_2 = new Boolean(var1_3.intValue() == new Integer(4).intValue());
      return rexpr_2;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).validNames);
    }
  }
// ***** VDMTOOLS END Name=validNames#1|Vector


// ***** VDMTOOLS START Name=resetGame KEEP=NO
  public void resetGame () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).resetGame);
    try {

      board.resetBoard();
      {

        Player p = null;
        for (Iterator enm_9 = players.iterator(); enm_9.hasNext(); ) {

          Player elem_3 = (Player) enm_9.next();
          p = (Player) elem_3;
          {

            p.updateScore(new Integer(0));
            p.initHand();
          }
        }
      }
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).resetGame);
    }
  }
// ***** VDMTOOLS END Name=resetGame


// ***** VDMTOOLS START Name=isGameOver KEEP=NO
  public Boolean isGameOver () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).isGameOver);
    try {

      Boolean b = new Boolean(true);
      {

        Player p = null;
        for (Iterator enm_8 = players.iterator(); enm_8.hasNext(); ) {

          Player elem_2 = (Player) enm_8.next();
          p = (Player) elem_2;
          if (canPlay((Player) p).booleanValue()) 
            b = (Boolean) UTIL.clone(new Boolean(false));
        }
      }
      return b;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).isGameOver);
    }
  }
// ***** VDMTOOLS END Name=isGameOver


// ***** VDMTOOLS START Name=rotatePiece#2|Player|Integer KEEP=NO
  public void rotatePiece (final Player p, final Integer times) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).rotatePiece);
    try {

      Integer i = new Integer(0);
      while ( new Boolean((i.intValue()) <= (times.intValue())).booleanValue()){

        Piece obj_7 = null;
        obj_7 = (Piece) p.getPlayingPiece();
        obj_7.rotate();
        i = UTIL.NumberToInt(UTIL.clone(new Integer(i.intValue() + new Integer(1).intValue())));
      }
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).rotatePiece);
    }
  }
// ***** VDMTOOLS END Name=rotatePiece#2|Player|Integer


// ***** VDMTOOLS START Name=flipPiece#2|Player|Integer KEEP=NO
  public void flipPiece (final Player p, final Integer times) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).flipPiece);
    try {

      Integer i = new Integer(0);
      while ( new Boolean((i.intValue()) <= (times.intValue())).booleanValue()){

        Piece obj_7 = null;
        obj_7 = (Piece) p.getPlayingPiece();
        obj_7.flip();
        i = UTIL.NumberToInt(UTIL.clone(new Integer(i.intValue() + new Integer(1).intValue())));
      }
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).flipPiece);
    }
  }
// ***** VDMTOOLS END Name=flipPiece#2|Player|Integer


// ***** VDMTOOLS START Name=passTurn KEEP=NO
  public void passTurn () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).passTurn);
    try {
      getNextPlayerToPlay();
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).passTurn);
    }
  }
// ***** VDMTOOLS END Name=passTurn


// ***** VDMTOOLS START Name=getPlayerByColor#1|Object KEEP=NO
  public Player getPlayerByColor (final Object color) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getPlayerByColor);
    try {

      Player ret = null;
      {

        Player p = null;
        for (Iterator enm_10 = players.iterator(); enm_10.hasNext(); ) {

          Player elem_3 = (Player) enm_10.next();
          p = (Player) elem_3;
          {

            Boolean cond_6 = null;
            Object var1_7 = null;
            var1_7 = p.getColor();
            cond_6 = new Boolean(UTIL.equals(var1_7, color));
            if (cond_6.booleanValue()) 
              ret = (Player) UTIL.clone(p);
          }
        }
      }
      return (Player) ret;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getPlayerByColor);
    }
  }
// ***** VDMTOOLS END Name=getPlayerByColor#1|Object


// ***** VDMTOOLS START Name=getNextPlayerToPlay KEEP=NO
  public void getNextPlayerToPlay () throws CGException {

    sentinel.entering(((GameSentinel) sentinel).getNextPlayerToPlay);
    try {

      Object color = null;
      color = currentPlayer.getColor();
      boolean succ_1 = true;
      {

        succ_1 = true;
        if (!UTIL.equals(color, new quotes.BLUE())) 
          succ_1 = false;
        if (succ_1) 
          currentPlayer = (Player) UTIL.clone((Player) getPlayerByColor(new quotes.YELLOW()));
        else {

          succ_1 = true;
          if (!UTIL.equals(color, new quotes.YELLOW())) 
            succ_1 = false;
          if (succ_1) 
            currentPlayer = (Player) UTIL.clone((Player) getPlayerByColor(new quotes.RED()));
          else {

            succ_1 = true;
            if (!UTIL.equals(color, new quotes.RED())) 
              succ_1 = false;
            if (succ_1) 
              currentPlayer = (Player) UTIL.clone((Player) getPlayerByColor(new quotes.GREEN()));
            else {

              succ_1 = true;
              if (!UTIL.equals(color, new quotes.GREEN())) 
                succ_1 = false;
              if (succ_1) 
                currentPlayer = (Player) UTIL.clone((Player) getPlayerByColor(new quotes.BLUE()));
            }
          }
        }
      }
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).getNextPlayerToPlay);
    }
  }
// ***** VDMTOOLS END Name=getNextPlayerToPlay


// ***** VDMTOOLS START Name=pieceFits#2|Piece KEEP=NO
  public Boolean pieceFits (final Piece piece, final Piece.Coord start_ucoord) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).pieceFits);
    try {

      HashMap m = new HashMap();
      m = piece.getPositionsToDraw();
      Vector coords = null;
      Object tmppar_4 = null;
      tmppar_4 = piece.getCurrDirection();
      coords = (Vector) UTIL.ConvertToList(m.get(tmppar_4));
      Integer i = new Integer(1);
      Boolean b = new Boolean(true);
      Piece.Coord c = null;
      while ( new Boolean((i.intValue()) <= (new Integer(coords.size()).intValue())).booleanValue()){

        Piece.Coord rhs_9 = null;
        Double tmpVar_10 = null;
        Double var1_11 = null;
        var1_11 = (start_ucoord).x;
        Double var2_13 = null;
        Piece.Coord tmpRec_14 = null;
        if ((1 <= i.intValue()) && (i.intValue() <= coords.size())) 
          tmpRec_14 = (Piece.Coord) coords.get(i.intValue() - 1);
        else 
          UTIL.RunTime("Run-Time Error:Illegal index");
        var2_13 = (tmpRec_14).x;
        tmpVar_10 = new Double(var1_11.doubleValue() + var2_13.doubleValue());
        Double tmpVar_17 = null;
        Double var1_18 = null;
        var1_18 = (start_ucoord).y;
        Double var2_20 = null;
        Piece.Coord tmpRec_21 = null;
        if ((1 <= i.intValue()) && (i.intValue() <= coords.size())) 
          tmpRec_21 = (Piece.Coord) coords.get(i.intValue() - 1);
        else 
          UTIL.RunTime("Run-Time Error:Illegal index");
        var2_20 = (tmpRec_21).y;
        tmpVar_17 = new Double(var1_18.doubleValue() + var2_20.doubleValue());
        rhs_9 = new Piece.Coord(tmpVar_10, tmpVar_17);
        c = (Piece.Coord) UTIL.clone(rhs_9);
        Boolean cond_24 = null;
        Object var1_25 = null;
        HashMap tmp_m_26 = new HashMap();
        tmp_m_26 = board.board;
        var1_25 = tmp_m_26.get(c);
        cond_24 = new Boolean(!UTIL.equals(var1_25, new quotes.NONE()));
        if (cond_24.booleanValue()) 
          b = (Boolean) UTIL.clone(new Boolean(false));
      }
      return b;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).pieceFits);
    }
  }
// ***** VDMTOOLS END Name=pieceFits#2|Piece


// ***** VDMTOOLS START Name=play#3|Player|Piece KEEP=NO
  public void play (final Player player, final Piece piece, final Piece.Coord start_ucoord) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).play);
    try {
      if (validMove((Player) player, (Piece) piece, start_ucoord).booleanValue()) 
        board.drawPiece((Piece) piece, start_ucoord);
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).play);
    }
  }
// ***** VDMTOOLS END Name=play#3|Player|Piece


// ***** VDMTOOLS START Name=canPlay#1|Player KEEP=NO
  public Boolean canPlay (final Player player) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).canPlay);
    try {

      HashMap empties = new HashMap();
      empties = board.getEmptyCoords();
      Boolean b = new Boolean(false);
      Boolean cond_2 = null;
      Integer var1_3 = null;
      Vector unArg_4 = null;
      unArg_4 = player.getPieces();
      var1_3 = new Integer(unArg_4.size());
      cond_2 = new Boolean((var1_3.intValue()) > (new Integer(0).intValue()));
      if (cond_2.booleanValue()) {

        HashSet iset_6 = new HashSet();
        iset_6.clear();
        iset_6.addAll(empties.keySet());
        Piece.Coord c = null;
        for (Iterator enm_44 = iset_6.iterator(); enm_44.hasNext(); ) {

          Piece.Coord elem_7 = (Piece.Coord) enm_44.next();
          c = elem_7;
          {

            if (new Boolean(UTIL.equals(b, new Boolean(true))).booleanValue()) 
              return b;
            {

              HashSet iset_16 = new HashSet();
              Vector unArg_23 = null;
              unArg_23 = player.getPieces();
              HashSet set_24 = new HashSet();
              Enumeration enm_25 = unArg_23.elements();
              while ( enm_25.hasMoreElements())
                set_24.add(enm_25.nextElement());
              iset_16 = set_24;
              Piece p = null;
              for (Iterator enm_43 = iset_16.iterator(); enm_43.hasNext(); ) {

                Piece elem_17 = (Piece) enm_43.next();
                p = (Piece) elem_17;
                {

                  if (new Boolean(UTIL.equals(b, new Boolean(true))).booleanValue()) 
                    return b;
                  Boolean cond_30 = null;
                  Boolean var1_31 = null;
                  Boolean var1_32 = null;
                  var1_32 = board.doesPieceTouchCorner((Piece) p, c);
                  {
                    if ((var1_31 = var1_32).booleanValue()) {

                      Boolean var2_35 = null;
                      Boolean unArg_36 = null;
                      unArg_36 = board.isPieceOutOfBounds((Piece) p, c);
                      var2_35 = new Boolean(!unArg_36.booleanValue());
                      var1_31 = var2_35;
                    }
                  }
                  {
                    if ((cond_30 = var1_31).booleanValue()) {

                      Boolean var2_39 = null;
                      var2_39 = board.doesPieceFit((Piece) p, c);
                      cond_30 = var2_39;
                    }
                  }
                  if (cond_30.booleanValue()) 
                    b = (Boolean) UTIL.clone(new Boolean(true));
                }
              }
            }
          }
        }
      }
      return b;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).canPlay);
    }
  }
// ***** VDMTOOLS END Name=canPlay#1|Player


// ***** VDMTOOLS START Name=validMove#3|Player|Piece KEEP=NO
  public Boolean validMove (final Player player, final Piece piece, final Piece.Coord start_ucoord) throws CGException {

    sentinel.entering(((GameSentinel) sentinel).validMove);
    try {

      Boolean b = new Boolean(false);
      if (canPlay((Player) player).booleanValue()) {

        Boolean cond_6 = null;
        Boolean var1_7 = null;
        Boolean var1_8 = null;
        Boolean var1_9 = null;
        Boolean unArg_10 = null;
        unArg_10 = board.isPieceOutOfBounds((Piece) piece, start_ucoord);
        var1_9 = new Boolean(!unArg_10.booleanValue());
        {
          if ((var1_8 = var1_9).booleanValue()) {

            Boolean var2_13 = null;
            var2_13 = board.doesPieceFit((Piece) piece, start_ucoord);
            var1_8 = var2_13;
          }
        }
        {
          if ((var1_7 = var1_8).booleanValue()) {

            Boolean var2_16 = null;
            var2_16 = board.doesPieceTouchCorner((Piece) piece, start_ucoord);
            var1_7 = var2_16;
          }
        }
        {
          if ((cond_6 = var1_7).booleanValue()) {

            Boolean var2_19 = null;
            Boolean unArg_20 = null;
            unArg_20 = board.doesPieceTouchSameColorOnSides((Piece) piece, start_ucoord);
            var2_19 = new Boolean(!unArg_20.booleanValue());
            cond_6 = var2_19;
          }
        }
        if (cond_6.booleanValue()) 
          b = (Boolean) UTIL.clone(new Boolean(true));
      }
      return b;
    }
    finally {
      sentinel.leaving(((GameSentinel) sentinel).validMove);
    }
  }
// ***** VDMTOOLS END Name=validMove#3|Player|Piece

}
;
