
package com.academus.tekst;


import javax.swing.text.PlainDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;


public class JTextFieldLimit extends PlainDocument {
    
    private int limit;
    
    public JTextFieldLimit(int limitation)
    {
        this.limit = limitation;
    }
    
    @Override
    public void insertString(int offset, String str, AttributeSet set) throws 
            BadLocationException
            
    {
        if (str == null)
        {
        }
        else if((getLength() + str.length() <= limit ))
        {
            
            
            super.insertString(offset,str, set);
            
            
        }
            
    }
    
}
