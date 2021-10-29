/*
 *@author: Jose Soto
 */

public class CardPlayer {
private Card ficha;
private int loc;
public CardPlayer(Card f, int d){
    ficha=f;
    loc=d;
}

    public Card getFicha() {
        return ficha;
    }

    public int getLoc() {
        return loc;
    }

}
