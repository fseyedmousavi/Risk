package risk;

public class State {

    private int soldierNo = 1;
    private Player owner;

    public State() {
    }

    public State(String continenrName) {
    }

    public int getSoldierNo() {
        return soldierNo;
    }

    public void setSoldierNo(int soldierNo) {
        this.soldierNo = soldierNo;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = new Player();
        this.owner = owner;
    }
}
