package sample;
import flockbase.Bird;
import flockbase.Position;
import java.*;

public class BirdX extends Bird{
    private int isLeader;
    private static int index = 0;
    private static int quadrant =0;
    public BirdX(){
        super();
    }

    public String getName(){
        if(this.isLeader==1){
            return "Leader";
        }
        else{
            return "X";
        }
    }

    public void becomeLeader(){
        this.isLeader = 1;
    }

    public void retireLead(){
        this.isLeader = 0;
    }

    protected void updatePos(){
        System.out.println("hello");
        int currentX = this.getPos().getX();
        int currentY = this.getPos().getY();
        int nextX = this.getTarget().getX();
        int nextY = this.getTarget().getY();

        System.out.println("currentX" + currentX);
        System.out.println("currentY" + currentY);
        System.out.println("nextX" + nextX);
        System.out.println("nextY" + nextY);
        int intermediateX = currentX;
        int intermediateY = currentY;
  
        // int index=0;


        if(this.isLeader==0){
            int leaderPosX = this.getFlock().getLeader().getPos().getX();
            int leaderPosY = this.getFlock().getLeader().getPos().getY();
            System.out.println("quadrant" + this.quadrant);
            if(quadrant==1){
            this.setTarget(leaderPosX+(10*this.getFlock().getBirds().indexOf(this)),leaderPosY+(10*this.getFlock().getBirds().indexOf(this)));
            }

            else if(quadrant==2){
                this.setTarget(leaderPosX-(10*this.getFlock().getBirds().indexOf(this)),leaderPosY+(10*this.getFlock().getBirds().indexOf(this)));
            }

            else if(quadrant==3){
             this.setTarget(leaderPosX+(10*this.getFlock().getBirds().indexOf(this)),leaderPosY-(10*this.getFlock().getBirds().indexOf(this)));   
            }

            else if(quadrant==4){
                 this.setTarget(leaderPosX-(10*this.getFlock().getBirds().indexOf(this)),leaderPosY-(10*this.getFlock().getBirds().indexOf(this)));
            }
        }


        if(intermediateX>nextX && intermediateY<nextY){
            quadrant = 3;
          
            if((intermediateX-nextX)>10 && (nextY-intermediateY)>10){
                if(index%2==0 ){
                    intermediateX = intermediateX - (intermediateX-nextX)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                    
                else{
                    intermediateY = intermediateY + (nextY-intermediateY)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                
            }

            else{
                    this.getPos().setPos(nextX,nextY);
            }

         
        }

        else if(intermediateX>nextX && intermediateY>nextY){
            quadrant = 1;

            if((intermediateX-nextX)>10 && (intermediateY-nextY)>10){
                if(index%2==0 ){
                    intermediateX = intermediateX - (intermediateX-nextX)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                    
                else{
                    intermediateY = intermediateY - (intermediateY-nextY)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                
            }

            else{
                    this.getPos().setPos(nextX,nextY);
            }
         
        }

        else if(intermediateX<nextX && intermediateY>nextY){
            quadrant = 2;

            if((nextX-intermediateX)>10 && (intermediateY-nextY)>10){
                if(index%2==0 ){
                    intermediateX = intermediateX + (nextX-intermediateX)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                    
                else{
                    intermediateY = intermediateY - (intermediateY-nextY)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                
            }

            else{
                    this.getPos().setPos(nextX,nextY);
            }
         
        }


        else if(intermediateX<nextX && intermediateY<nextY){
            quadrant = 4;

            if((nextX-intermediateX)>10 && (nextY-intermediateY)>10){
                if(index%2==0 ){
                    intermediateX = intermediateX + (nextX-intermediateX)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                    
                else{
                    intermediateY = intermediateY + (nextY-intermediateY)/10;
                    this.getPos().setPos(intermediateX,intermediateY);
                    index++;
                }
                
            }

            else{
                    this.getPos().setPos(nextX,nextY);
            }
         
        }
        


     



    }


}