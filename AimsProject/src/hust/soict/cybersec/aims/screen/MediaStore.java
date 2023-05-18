package hust.soict.cybersec.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

import hust.soict.cybersec.aims.store.Store;
import hust.soict.cybersec.aims.media.*;


public class MediaStore extends JPanel {
    
    private Media media;

    public MediaStore(Media media) {

        this.media = media;
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
                JOptionPane.showMessageDialog(null, media.getTitle() + " added to cart");
            }
        });
        container.add(addToCartButton);
        


        
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Open a dialog window to play the media
                    JDialog dialog = new JDialog();
                    dialog.setTitle(media.getTitle());
                    dialog.setSize(400, 300);
                    
                    JLabel mediaLabel = new JLabel(media.playGUI());
                    mediaLabel.setVerticalAlignment(JLabel.CENTER); 
                    mediaLabel.setHorizontalAlignment(JLabel.CENTER);
                    JScrollPane scrollPane = new JScrollPane(mediaLabel);
                    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
                    // scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
                    
                    dialog.add(scrollPane);
                    dialog.setVisible(true);
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