//*************************************************************************************
//  DeckOfCard.java
//
//  Dustin Kaban
//  April 20th, 2020
//  This class handles a DeckOfCards Object, which is a set of 52 Card Objects
//  It allows for the user to shuffle the deck as well as deal cards.
//*************************************************************************************
import java.util.Random;
import java.util.Arrays;

public class DeckOfCards
{
    //The deck array and the size of the array variables are created
    public Card[] deck;
    private final int DECKSIZE = 52;

    public DeckOfCards()
    {
        //We create a deck of cards by assigning each card a suit and a face (unique combinations)
        deck = new Card[DECKSIZE];
        int suitMaxValue = 4;
        int faceMaxValue = 13;
        int deckIndex = 0;
        for(int s=1;s<=suitMaxValue;s++)
        {
            for(int f=1;f<=faceMaxValue;f++)
            {
                deck[deckIndex] = new Card(f,s);
                deckIndex++;
            }
        }
    }

    public void shuffleDeck()
    {
        Random random = new Random();
        //We loop through the deck and assign an element the value of random element
        for(int i=0;i<deck.length;i++)
        {
            int randomIndex = random.nextInt(deck.length-1);
            //Storing a temp value to hold the value of the previous card, to assign it to the random element
            Card tempCard = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = tempCard;
        }
    }

    public Card dealCard()
    {
        if(deck.length > 1)
        {
            Random random = new Random();
            //We choose a random element in the deck and "deal" that card
            int cardIndex = random.nextInt(deck.length-1);
            Card dealtCard = deck[cardIndex];
            //We want to remove the dealt card from the array because its no longer useful
            deck = removeCard(cardIndex);
            return dealtCard;
        }
        else
        {
            Card dealtCard = deck[0];
            deck = new Card[0];
            return dealtCard;
        }
    }

    private Card[] removeCard(int cardIndex)
    {
        //This removes an element from the array (the dealt card we already gave out)
        Card[] reducedArray = new Card[deck.length - 1];
        int remainingElements = deck.length - ( cardIndex + 1 );
        //This copies the values from 0 to the index we're removing
        System.arraycopy(deck, 0, reducedArray, 0, cardIndex);
        //We also want to copy values from the index+1 to the end of the array
        System.arraycopy(deck, cardIndex + 1, reducedArray, cardIndex, remainingElements);
        //We return the array with the element removed
        return reducedArray;
    }

    public int getCardCountRemaining()
    {
        return deck.length;
    }

    public String toString()
    {
        return Arrays.toString(deck);
    }
}
