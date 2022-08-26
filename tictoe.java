 // create borders
    Border default_top_border = BorderFactory.createMatteBorder(2, 0, 0, 0, new Color(204,204,204));
    Border red_top_border = BorderFactory.createMatteBorder(2, 0, 0, 0, Color.red);
    Border textField_border = BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red);
    
    // create an array of componenet
    Component[] comps;
    HashMap<Component, String> map = new HashMap<>();
    
    public Login_Register() {
        initComponents();
        
        // center form 
        this.setLocationRelativeTo(null);
        
        // we can add a focus in and out like we did in the login panel
        // or we can make it with a loop
        
        // populate the comps
        comps = jPanel_register.getComponents();
        
        // populate the hashmap
        for (Component comp : comps) {
           
            if(comp instanceof JTextField)
            {
                JTextField textField = (JTextField) comp;
                map.put(textField,textField.getText());
            }
            else if(comp instanceof JPasswordField)
            {
                JPasswordField passField = (JPasswordField) comp;
                map.put(passField,String.valueOf(passField.getPassword()));
            }
            
        }
        
        // set borders
        jLabel_login.setBorder(default_top_border);
        jLabel_register.setBorder(default_top_border);
        jTextField_login_username.setBorder(textField_border);
        jPasswordField_login_pass.setBorder(textField_border);
        jTextField_register_username.setBorder(textField_border);
        jTextField_register_email.setBorder(textField_border);
        jPasswordField_register_pass.setBorder(textField_border);
        jPasswordField_register_confirmPass.setBorder(textField_border);
        
        // show icons
        jLabel_close.setIcon(new ImageIcon(getClass().getResource("IMAGES/x-mark.png")));
        jLabel_login_username.setIcon(new ImageIcon(getClass().getResource("IMAGES/contacts.png")));
        jLabel_login_password.setIcon(new ImageIcon(getClass().getResource("IMAGES/lock.png")));
        jLabel_register_username.setIcon(new ImageIcon(getClass().getResource("IMAGES/contacts.png")));
        jLabel_register_email.setIcon(new ImageIcon(getClass().getResource("IMAGES/email.png")));
        jLabel_register_password.setIcon(new ImageIcon(getClass().getResource("IMAGES/lock.png")));
        jLabel_register_confirm_password.setIcon(new ImageIcon(getClass().getResource("IMAGES/ok.png")));
        
        // add the focus events
        addFocusEvent();
        
        // call the jlabel mouse click event
        jLabel_loginMouseClicked(null);
        
    }   


    // create a function for the focus in
    public void focusIn(JTextField textField, JPasswordField passField, String originalText)
    {
        // for the jpassword
        if(passField != null)
        {
            String passValue = String.valueOf(passField.getPassword());
            
            if(passValue.equals(originalText))
            {
                passField.setText("");
                passField.setForeground(Color.black);
            }
            
        }
        // for the jtextfield
        else
        {
            String textFieldValue = textField.getText().trim().toLowerCase();
        
            if(textFieldValue.equals(originalText))
            {
                textField.setText("");
                textField.setForeground(Color.black);
            }
        }
        
    }
    
    // create a function for the focus out
    public void focusOut(JTextField textField, JPasswordField passField, String originalText)
    {
        // for the jpassword
        if(passField != null)
        {
            String passValue = String.valueOf(passField.getPassword());
            
            if(passValue.equals(originalText) || passValue.equals(""))
            {
                passField.setText(originalText);
                passField.setForeground(new Color(153,153,153));
            }
            
        }
        
        // for the jtextfield
        else
        {
            String textFieldValue = textField.getText().trim().toLowerCase();

            if(textFieldValue.equals(originalText) || textFieldValue.equals(""))
            {
                textField.setText(originalText);
                textField.setForeground(new Color(153,153,153));
            }
        }
    }


    private void jTextField_login_usernameFocusGained(java.awt.event.FocusEvent evt) {                                                      
        // if the jtextfield text = username
        // clear the textfield
        String usernameValue = jTextField_login_username.getText().trim().toLowerCase();
        
        if(usernameValue.equals("username"))
        {
            jTextField_login_username.setText("");
            jTextField_login_username.setForeground(Color.black);
        }
        
    }                                                     

    private void jTextField_login_usernameFocusLost(java.awt.event.FocusEvent evt) {                                                    
        // if the textfield is empty -> set the text to 'username'
        String usernameValue = jTextField_login_username.getText().trim().toLowerCase();
        
        if(usernameValue.equals("username") || usernameValue.equals(""))
        {
            jTextField_login_username.setText("username");
            jTextField_login_username.setForeground(new Color(153,153,153));
        }
        
    }                                                   


    private void jPasswordField_login_passFocusGained(java.awt.event.FocusEvent evt) {                                                      
        // if the jpassword text = password
        // clear the textfield
        String passValue = String.valueOf(jPasswordField_login_pass.getPassword()).trim().toLowerCase();
        
        if(passValue.equals("password"))
        {
            jPasswordField_login_pass.setText("");
            jPasswordField_login_pass.setForeground(Color.black);
        }
    }                                                     

    private void jPasswordField_login_passFocusLost(java.awt.event.FocusEvent evt) {                                                    
        // if the textfield is empty -> set the text to 'password'
        String passValue = String.valueOf(jPasswordField_login_pass.getPassword()).trim().toLowerCase();
        
        if(passValue.equals("password") || passValue.equals(""))
        {
            jPasswordField_login_pass.setText("password");
            jPasswordField_login_pass.setForeground(new Color(153,153,153));
        }
    }                                                   



    // add the focus event to jtextfields
    public void addFocusEvent()
    {
        for (Component comp : comps) {
           
            if(comp instanceof JTextField)
            {
                JTextField textField = (JTextField) comp;
                
                textField.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        
                        focusIn(textField, null, map.get(textField));
                        
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        
                        focusOut(textField, null, map.get(textField));
                        
                    }
                });
            }
            else if(comp instanceof JPasswordField)
            {
                JPasswordField passField = (JPasswordField) comp;
                
                passField.addFocusListener(new FocusListener() {
                    @Override
                    public void focusGained(FocusEvent e) {
                        
                        focusIn(passField, null, map.get(passField));
                        
                    }

                    @Override
                    public void focusLost(FocusEvent e) {
                        
                        focusOut(passField, null, map.get(passField));
                        
                    }
                });
            }
            
        }
    }


    private void jLabel_closeMouseClicked(java.awt.event.MouseEvent evt) {                                          
        // close this form
        this.dispose();
    }