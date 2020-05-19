//*************************************************************************************
//  Card.java
//
//  Dustin Kaban
//  April 20th, 2020
//  This class is the Card Object that contains all the information about the card itself
//  This class contains 2 constructors, one allowing for input to select a suit and rank,
//  another choosing a randomly selected card.  The class has getters for
//  suitText, faceValue, and faceText.
//*************************************************************************************
import java.util.Random;

public class Card
{
    //Enumerated lists to contain the SuitTypes and the Face Ranks
    enum suits {Hearts, Diamonds, Spades, Clubs}
    enum faceRanks {Ace,Two,Three,Four,Five,Six,Seven,Eight,Nine,Ten,Jack,Queen,King}
    private suits suit;
    private faceRanks faceRank;
    private int faceValue;
    //Max and Min values to allow for customizing the size of randomization for faces and suits
    private int maxFace=13,minFace=1;
    private int maxSuit=4,minSuit=1;
    private Random random = new Random();

    //Constructor allows for input of the rank and suit
    public Card(int rank, int suitValue)
    {
        faceRank = setFace(rank);
        faceValue = rank;
        suit = setSuit(suitValue);
    }

    //A default constructor that randomly assigns values for a card
    public Card()
    {
        faceValue = random.nextInt(maxFace) + minFace;
        faceRank = setFace(faceValue);
        suit = setSuit(random.nextInt(maxSuit) + minSuit);
    }

    //setSuit takes in an integer and assigns a value from the enumerated list suits
    private suits setSuit(int suitValue)
    {
        switch(suitValue)
        {
            case 1:
                return suits.Hearts;
            case 2:
                return suits.Diamonds;
            case 3:
                return suits.Spades;
            case 4:
                return suits.Clubs;
            default:
                break;
        }
        return null;
    }

    //setFace takes in an int and returns the corresponding value in the faceRanks enumerated list
    private faceRanks setFace(int rank)
    {
        switch(rank)
        {
            case 1:
                return faceRanks.Ace;
            case 2:
                return faceRanks.Two;
            case 3:
                return faceRanks.Three;
            case 4:
                return faceRanks.Four;
            case 5:
                return faceRanks.Five;
            case 6:
                return faceRanks.Six;
            case 7:
                return faceRanks.Seven;
            case 8:
                return faceRanks.Eight;
            case 9:
                return faceRanks.Nine;
            case 10:
                return faceRanks.Ten;
            case 11:
                return faceRanks.Jack;
            case 12:
                return faceRanks.Queen;
            case 13:
                return faceRanks.King;
            default:

                break;
        }
        return null;
    }

    public String getSuitText()
    {
        return suit.toString();
    }

    public int getFaceValue()
    {
        return faceValue;
    }

    public String getFaceText()
    {
        return faceRank.toString();
    }

    //toString returns a string with the card information.  If anything is null, it reports invalid
    public String toString()
    {
        String cardDescription;

        if(faceRank == null || suit == null)
        {
            cardDescription = "Card is Invalid";
        }
        else
        {
            cardDescription = faceRank + " of " + suit;
        }
        return cardDescription;
    }
}
