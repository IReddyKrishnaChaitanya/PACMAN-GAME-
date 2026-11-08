import java.awt.*;  
import java.awt.event.*;
import java.util.HashSet;   
import java.util.Random;
import javax.swing.*;

public class PacMan extends JPanel  implements  ActionListener
{
    class Block
    {
        int x;
        int y;
        int width;
        int height;
        Image image;

        int startX;
        int startY;

        Block(Image image ,int x, int y, int width, int height)
        {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.image = image;
            this.startX = x;
            this.startY = y;
        }
    }
    private int rowCount = 21;
    private int colCount = 19;
    private int tileSize = 32;
    private int boardWidth = colCount * tileSize;                                                   
    private int boardHeight = rowCount * tileSize;

    private Image wallImage;
    private Image blueGhostImage;
    private Image redGhostImage;
    private Image pinkGhostImage;
    private Image orangeGhostImage;
    
    private Image pacmanUpImage;
    private Image pacmanDownImage;
    private Image pacmanLeftImage;
    private Image pacmanRightImage;
    

    HashSet<Block> walls;
    HashSet<Block> foods;
    HashSet<Block> ghosts;
    Block pacman;


       //X = wall, O = skip, P = pac man, ' ' = food
    //Ghosts: b = blue, o = orange, p = pink, r = red
    private String[] tileMap = 
    {
        "XXXXXXXXXXXXXXXXXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X                 X",
        "X XX X XXXXX X XX X",
        "X    X       X    X",
        "XXXX XXXX XXXX XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXrXX X XXXX",
        "O       bpo       O",
        "XXXX X XXXXX X XXXX",
        "OOOX X       X XOOO",
        "XXXX X XXXXX X XXXX",
        "X        X        X",
        "X XX XXX X XXX XX X",
        "X  X     P     X  X",
        "XX X X XXXXX X X XX",
        "X    X   X   X    X",
        "X XXXXXX X XXXXXX X",
        "X                 X",
        "XXXXXXXXXXXXXXXXXXX" 
    };
    
    
    PacMan() 
    {
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        setBackground(Color.BLACK);

        // load images
        wallImage = new ImageIcon(getClass().getResource("./wall.png")).getImage();
        blueGhostImage = new ImageIcon(getClass().getResource("./blueghost.png")).getImage();
        redGhostImage = new ImageIcon(getClass().getResource("./redghost.png")).getImage();
        pinkGhostImage = new ImageIcon(getClass().getResource("./pinkghost.png")).getImage();
        orangeGhostImage = new ImageIcon(getClass().getResource("./orangeghost.png")).getImage();
       
       
        pacmanUpImage = new ImageIcon(getClass().getResource("./pacmanUp.png")).getImage();
        pacmanDownImage = new ImageIcon(getClass().getResource("./pacmanDown.png")).getImage();
        pacmanLeftImage = new ImageIcon(getClass().getResource("./pacmanLeft.png")).getImage();
        pacmanRightImage = new ImageIcon(getClass().getResource("./pacmanRight.png")).getImage();

        loadMap();
        System.out.println(walls.size());
        System.out.println(foods.size());
        System.out.println(ghosts.size());
        
    }
    public void loadMap()
    {
        walls = new  HashSet<Block>();
        foods = new  HashSet<Block>();
        ghosts = new HashSet<Block>();
        
        for (int r = 0; r < rowCount; r++)
             {
            for(int c=0;c<colCount;c++)
                {
                     String row = tileMap[r];
                     char tileMapChar = row.charAt(c);

                     int x=c*tileSize;
                     int y=r*tileSize;   

                    if (tileMapChar == 'X')
                        { //WALL BLOCK
                             Block wall = new Block(wallImage, x, y, tileSize, tileSize);
                             walls.add(wall);
                        }
                else if (tileMapChar == 'b')//blueghost
                    {
                        Block blueGhost = new Block(blueGhostImage, x, y, tileSize, tileSize);
                        ghosts.add(blueGhost);}
                else if (tileMapChar == 'r') //redghost
                    {
                        Block redGhost = new Block(redGhostImage, x, y, tileSize, tileSize);
                        ghosts.add(redGhost);
                    }
                else if (tileMapChar == 'p') //pinkghost
                    {
                        Block pinkGhost = new Block(pinkGhostImage, x, y, tileSize, tileSize);
                        ghosts.add(pinkGhost);
                    }
                else if (tileMapChar == 'o')    //orangeghost
                    {
                        Block orangeGhost = new Block(orangeGhostImage, x, y, tileSize, tileSize);
                        ghosts.add(orangeGhost);
                    }
                else if (tileMapChar == 'P')//pacman
                    {
                        pacman = new Block(pacmanRightImage, x, y, tileSize, tileSize);
                    }
                else if (tileMapChar == ' ')// food
                    {
                        Block food = new Block(null, x + 14 , y + 14,4, 4);
                        foods.add(food);
                    }
                }
            }
        }  

        public void paintComponent(Graphics g) 
        {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g){
           g.drawImage(pacman.image, pacman.x, pacman.y, pacman.width, pacman.height,this);

           for(Block ghost :ghosts)
           {
               g.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height, this);
           }
           for(Block wall : walls)
           {
               g.drawImage(wall.image, wall.x, wall.y, wall.width, wall.height, this);
           }
           g.setColor(Color.WHITE);
           for(Block food : foods)
           {
               g.fillOval(food.x, food.y, food.width, food.height);
           }
        }
        @Override 
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
          throw new UnsupportedException("Unimplemented method 'actionPerformed'");  
        }
    }


