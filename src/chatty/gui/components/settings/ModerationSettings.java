
package chatty.gui.components.settings;

import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author tduva
 */
public class ModerationSettings extends SettingsPanel {
    
    public ModerationSettings(final SettingsDialog d) {
        JPanel blah = addTitledPanel("Messages (can only be received as a mod)", 0);
        
        blah.add(d.addSimpleBooleanSetting(
                "showModActions",
                "<html><body>Show moderator actions in chat (similiar to <code>Extra - Moderation Log</code>)",
                "Show what commands mods perform, except your own (you can also open Extra - Moderation Log)"),
                d.makeGbc(0, 4, 3, 1, GridBagConstraints.WEST));
        
        blah.add(d.addSimpleBooleanSetting("showAutoMod", "Show messages rejected by AutoMod", ""),
                d.makeGbc(0, 5, 3, 1, GridBagConstraints.WEST));
        
        blah.add(new JLabel("<html><body style='width:300px;'>"
                + "To approve messages open <code>Extra - AutoMod</code>. "
                + "You can also set a custom hotkey to open dialogs (go "
                + "to <code>Hotkeys</code> settings, add a new item and select "
                + "<code>Dialog: AutoMod Dialog</code> as action)."),
                d.makeGbc(1, 6, 2, 1, GridBagConstraints.EAST));
        
        JPanel bleh = addTitledPanel("Other Settings", 1);
        
        bleh.add(d.addSimpleBooleanSetting(
                "closeUserDialogOnAction",
                "Close User Info Dialog when performing action (Button)",
                "After clicking on a button, the User Info Dialog will automatically close."),
                d.makeGbc(0, 0, 1, 1, GridBagConstraints.EAST));
    }
    
}
