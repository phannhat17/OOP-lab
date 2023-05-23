package hust.soict.cybersec.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.exception.PlayerException;
import hust.soict.cybersec.aims.media.*;


public class MediaStore extends JPanel {
        public MediaStore(Media media, Cart cart) {

            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

            JLabel title = new JLabel(media.getTitle());
            title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
            title.setAlignmentX(CENTER_ALIGNMENT);

            JLabel cost = new JLabel(""+media.getCost()+"$");
            cost.setAlignmentX(CENTER_ALIGNMENT);

            JPanel container = new JPanel();
            container.setLayout(new FlowLayout(FlowLayout.CENTER));

            JButton addToCartButton = new JButton("Add to cart");
            addToCartButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String message = cart.addMedia(media);
                        JOptionPane.showMessageDialog(null, message);
                    } catch (LimitExceededException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            });
            container.add(addToCartButton);
            


        
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    JDialog dialog = new JDialog();
                    dialog.setTitle(media.getTitle());
                    dialog.setSize(400, 300);

                    String mediaInfo = "";
                    try {
                        mediaInfo = "<html>"+ media.playGUI().replace("\n", "<br/>") + "</html>";
                        JLabel mediaLabel = new JLabel(mediaInfo);
                        mediaLabel.setVerticalAlignment(JLabel.CENTER); 
                        mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                        JScrollPane scrollPane = new JScrollPane(mediaLabel);
                        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                        
                        dialog.add(scrollPane);
                        dialog.setVisible(true);
                    } catch (PlayerException e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

}
