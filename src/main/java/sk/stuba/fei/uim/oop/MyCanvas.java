package sk.stuba.fei.uim.oop;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;


public class MyCanvas extends Canvas{
    public ArrayList<Tree> trees = new ArrayList<Tree>();
    private Tree thisTree;
    int xpos,ypos;

    public MyCanvas() {
        super();
        this.xpos=0;
        this.ypos=0;
        this.trees=new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        this.trees.forEach(tree -> tree.draw(g));
    }

    public void startDraw(MouseEvent e,Color color){
        this.xpos=e.getX();
        this.ypos=e.getY();
        this.thisTree=new Tree(this.xpos,this.ypos,0,0,color);
        this.trees.add(thisTree);
        this.repaint();
    }

    public void startDrag(MouseEvent e){
        for (int i=this.trees.size()-1;i>=0;i--){
            Tree t = this.trees.get(i);
            if (t.clicked(e.getX(),e.getY())){
                this.thisTree=t;
                this.xpos=e.getX()-t.getX();
                this.ypos=e.getY()-t.getY();
            }
        }
    }

    public void draw(MouseEvent e){
        this.thisTree.setX(Math.min(xpos, e.getX()));
        this.thisTree.setY(Math.min(ypos, e.getY()));
        this.thisTree.setWidth(Math.abs(e.getX() - xpos));
        this.thisTree.setHeight(Math.abs(e.getY() - ypos));
        this.repaint();
    }

    public void drag(MouseEvent e){
        if (this.thisTree!=null){
            this.thisTree.setX(e.getX()-xpos);
            this.thisTree.setY(e.getY()-ypos);
        }
        this.repaint();
    }

    public void end(MouseEvent e){
        this.xpos = 0;
        this.ypos = 0;
        this.thisTree = null;
    }
}
