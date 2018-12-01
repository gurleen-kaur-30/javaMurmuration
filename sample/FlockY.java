package sample;
import flockbase.Bird;
import flockbase.Flock;
import java.util.ArrayList;


public class FlockY extends Flock{
    private Bird leader;
    private ArrayList<Bird> birds = new ArrayList<Bird>();

    protected void Flock() {
    }

	public void addBird(Bird b){
        this.birds.add(b);
        b.setFlock((Flock)this);
    }

	public void setLeader(Bird leader){
        leader.becomeLeader();
        this.leader = leader;
    }

	public ArrayList<Bird> getBirds(){
        return this.birds;
    }


	public Bird getLeader(){
        return this.leader;
    }
	
	public Flock split(int pos){
        FlockY newFlock = new FlockY();
        int leaderX = this.leader.getTarget().getX();
        int leaderY = this.leader.getTarget().getY();
        for(int i=pos;i<this.birds.size();i++){
            newFlock.addBird(this.birds.get(i));
        }
        newFlock.getBirds().get(0).setTarget(leaderX,leaderY);
        newFlock.getBirds().get(0).setPos(leaderX,leaderY);
        newFlock.setLeader(newFlock.getBirds().get(0));
        this.birds.subList(pos,this.birds.size()).clear();
        return newFlock;
    } 

	public void joinFlock(Flock f){
        for(int i=0;i<this.getBirds().size();i++) f.addBird(this.getBirds().get(i));
        this.getLeader().retireLead();
        f.getBirds().get(0).becomeLeader();
        this.birds.clear();
    } 

}