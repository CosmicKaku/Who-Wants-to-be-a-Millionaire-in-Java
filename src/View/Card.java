package View;

import javax.swing.*;
import java.awt.*;

public class Card extends JPanel
{
    private CardLayout cardLayout;

    public Card() {
        cardLayout = new CardLayout();
        setLayout(cardLayout);
    }

        public void addCardToStack(JPanel cardToAdd, String name)
        {
            this.add(cardToAdd, name);
            cardToAdd.setName(name);
            cardLayout.show(this, name);
        }

        public void showCard(String name)
        {
            cardLayout.show(this, name);
        }




}
