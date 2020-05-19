//*************************************************************************************
//  CardsDriver.java
//
//  Dustin Kaban
//  April 20th, 2020
//  This class Instantiates the Object DeckOfCards, uses the commands
//  shuffledeck from that object and then uses that class to display all
//  cards dealt one at a time to the user.
//*************************************************************************************
public class CardsDriver
{
    private static DeckOfCards cardDeck = new DeckOfCards();
    public static void main(String[] args)
    {
        //Run through the entire card deck and display all the cards to the user
        for(int i=0;i<cardDeck.deck.length;i++)
        {
            System.out.print(cardDeck.deck[i] + " , ");
            if((i+1)%4 == 0) System.out.println();
        }
        //Shuffle the deck and then deal all the cards
        cardDeck.shuffleDeck();
        dealAllCards();
    }

    private static void dealAllCards()
    {
        //Shuffle cards until there are no more cards left in the deck
        do {
            System.out.println("Card Dealt: " + cardDeck.dealCard());
            System.out.println("Cards Left: " + cardDeck.getCardCountRemaining());
        }while(cardDeck.deck.length>0);
    }
}
