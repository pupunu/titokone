package fi.hu.cs.titokone;

 /** This class is used to tell GUIBrain what compiler has done at the moment.
    CompileDebugger creates objects from this class and passes them to the 
    GUIBrain.
*/


public class CompileInfo extends DebugInfo {
  // Variables common to both rounds.
  
  public static final short FIRST_ROUND = 0;
  public static final short SECOND_ROUND = 1;
  public static final short FINALIZING = 2; 
  private short phase;
  /** This field contains the number of the line being processed or 
      -1 during the finalizing phase. */
  private int lineNumber;
  private String lineContents;
  private String statusMessage;
  private String comments;
  // Variables for first round.

  /** This field is by default false, but if the compiled line was 
      empty (or consisted of whitespace only), the true value here says 
      that other checks can be skipped. */
  private boolean lineEmpty = false;
  /** This field contains the name of a symbol found on this line 
      from the parameter field (this also includes labels in the parameter
      field, but not ones defined). It will be set to "" if no symbol 
      was found on this line. See also symbolValue, symbolDefined and
      label variables. */
  private String symbolName = "";
  /** This field is true if the symbol's value was also defined on this
      line. In this case, the value is set in symbolValue. */
  private boolean symbolDefined = false;
  /** This field contains the value of the symbol found. If symbolDefined
      is false, the value in this field should be ignored. */
  private int symbolValue;

    /** This field contains the address of the symbol.*/
    private int symbolAddress;

  // First or second round variable:
  /** This field contains the name of a label found from the beginning of
      this line. It will be set to "" if no label was found on this line.*/
  private String labelName = "";
  
  // Variables for the second round.

  private int lineBinary;

  private boolean labelDefined = false;
  private int labelValue;

  // Variables for finalization phase.

  /** This field contains true if we have gone through all DS and DC 
      commands and are setting FP and SP accordingly, or false if 
      we are still going through DS and DC commands. */
  private boolean finalFinal;

  public static final int SP_POS = 0;
  public static final int FP_POS = 1;
  /** This array contains the initial values of SP and FP, positioned
      according to SP_POS and FP_POS. */
  private int[] initPointers;

    /** These fields tells GUIBrain if compiler is setting DC and DS values.
     */
  private boolean definingDS; 
  private boolean definingDC;
  private int value; // DC/DS.

  
    /** This is normal constructor for CompileInfo. It sets initial values for
	phase, lineNumber and lineContents.
	@param phase Short indicating which phase is going on.
	@param lineNumber Integer value of the current line number.
	@param lineContents String containing symbolic command.
    */
  public CompileInfo(short phase, int lineNumber, String lineContents) {}
  
    /** This constructor is used when no actual line is compiled but other
	actions are made like setting DC or DS.
	@param phase short indicating which phase is going on.
    */
  public CompileInfo(short phase) {}
    
    /** This method sets lineEmpty value to true. */
    public void setLineEmpty(){}

    /** This method sets the statusMessage.
	@param statusMessage String containing the message.
    */
    public void setStatusMessage(String statusMessage){}
    
    /** This method sets the comments going to the GUI.
	@param comment String containing the comments.
    */
    public void setComments(String comment){}

    /** This field sets the name of a found symbol.
	@param name String containing the symbol name.
    */
    public void setSymbolName(String name){}
    
    /** This method sets the name of a found symbol and its value.
	@param name Name of the symbol.
	@param value Value of the symbol.
	@param address Memoryaddress of the symbol.
    */
    public void setSymbolName(String name, int address, int value){}
 
    /** This method sets the name of a found label and sets the labelDefined 
	field to true.
	@param name Name of the label.
    */
    public void setLabelName(String name){}
    
    /** This method tells CompileInfo that a given label was defined and it's
	value. It sets labelDefined field to true.
	@param name String containing the name of the label.
	@param value An integer value where the label points.
    */
    public void setLabelDefined(String name, int value){}
    
    /** This method tells what integer represents the compiled line of the
	code.
	@param binary An integer value representing the symbolic command.
    */
    public void setLineBinary(int binary){}


    public void setDefiningDS(int ADDR, int size){}
    /** This method sets the boolean field finalFinal to true.
     */
    public void setFinal(){}
    /** This method sets the initial SP and FP pointers to given values.
	@param SP Initial value of SP.
	@param FP Initial value of FP.
    */
    public void setInitPointers(int SP, int FP){}

    /** This method sets given line to given value.
	@param lineNumber Number of the line.
	@param value New value for the line.
    */
    public void setMemoryline(int lineNumber, int value){}

    /** This method returns the statusmessage.
	@return String containing the message.
    */
    public String returnStatusMessage(){}
 
    /** This method returns comments made by CompileDebugger.
	@return String containing the comments.
    */
    public String returnComments(){}
    
    /** This message tells that an empty line or line containing only 
	whitespaces was compiled.
    */
    public boolean returnLineEmpty(){}
    
    /** This method returns current phase as a short. 0 for first round, 1 for
	second and 2 for final.
	@return Short containing phase.
    */
    public short returnPhase(){}

    /** This method return symbolic contents of the line.
	@return String containing comments.
    */
    public String returnLineContents(){}

    /** This method returns found symbolname.
	@return String containing the name.
    */
    public String returnSymbolName(){}

    /** This method returns true if symbol was defined.
	@return boolean containing information if symbol was defined.
    */
    public boolean returnSymbolDefined(){}

    /** This method returns value of current symbol.
	@return An integer containing symbol's value.
    */
    public int returnSymbolValue(){}

    /** This method returns compiled binary machinecommand represented as an
	integer value.
	@return An integer representing machine command.
    */
    public int returnLineBinary(){}

    /** This method returns the name of the current label.
	@param String containing name of the label.
    */
    public String returnLabelName(){}

    /** This method returns value of the current label.
	@return An integer containing value of the label. */
    public int returnLabelValue(){} 

    /** This method tells GUIBrain that compiler is setting DS area.
     */
    public boolean returnDefiningDS(){} // samoin

    /** This methot tells GUIBrain that compiler is setting DC.
     */
    public boolean returnDefiningDC(){} //samoin

    /** This method returns the value of DC or DS.
	@return An integer containing value of DC or DS.
    */
    public int returnValue(){}

    /** This method returns true if field finalFinal is set.
	@return Boolean.
    */
    public boolean returnFinalPhase(){}

    /** This method returns initial SP and FP pointers in an interger array
	where first value is SP and second is FP.
	@return An integer array.
    */
    public int[] returnInitPointers(){}


}

