package poo;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Terreno extends ObjetoGrafico{

    //completar
    public int sizeCelda = 16;  //16 x 16 el tamaño de la celda para la imagen
    //private int ventanaColum = 48; //cuantas columnas quiero que tenga mi ventana
    //private int ventanaRow = 36; // cuantas filas quiero que tenga mi ventana
    
    Tile[] tile;
    int[][] posTile;
 
    public Terreno(String rutaTerreno, int sizeCelda){
        this.sizeCelda = sizeCelda;
        getImg();
        posTile=cargarMapaDesdeArchivo(rutaTerreno);

        
    }

    public void getImg(){
        //completar innicializando los numeros con imagenes
        try {
            tile = new Tile[10];
            tile[0] = new Tile(new BufferedImage(sizeCelda, sizeCelda, BufferedImage.TYPE_INT_ARGB),false);
           
            tile[1] = new Tile(ImageIO.read(getClass().getResourceAsStream("ImgLemming/tierra.png")),true);
            
            tile[2] = new Tile(ImageIO.read(getClass().getResourceAsStream("ImgLemming/tierraP.png")), true);
            


        } catch (Exception e) {
            System.out.println("Hay error acaaa" + e);
        }
    }

    private int[][] cargarMapaDesdeArchivo(String archivo) {
        ArrayList<int[]> filas = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream("ImgLemming/terrenoMatriz.txt");
         BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(" ");
                int[] fila = new int[partes.length];
                for (int i = 0; i < partes.length; i++) {
                    fila[i] = Integer.parseInt(partes[i]);
                }
                filas.add(fila);
            }
        } catch (IOException e) {
            System.out.println("error nuevoo" + e);
        }

        int[][] mapa = new int[filas.size()][];
        for (int i = 0; i < filas.size(); i++) {
            mapa[i] = filas.get(i);
        }
        return mapa;
    }


   /* public void leerTerrenoMatriz(){
        //completar
        try {
            InputStream coso = getClass().getResourceAsStream("ImgLemming/terrenoMatriz.txt");
            BufferedReader eso = new BufferedReader(new InputStreamReader(coso));

            int col = 0;
            int row = 0;

            while(col < ventanaColum && row < ventanaRow){
                String line = eso.readLine(); // va a leer una sola linea
                while(col < ventanaColum){
                    String nros[]= line.split(" ");
                    int num = Integer.parseInt(nros[col]);
                    posTile[col][row] = num;
                    col++;
                }
               
                if(col == ventanaColum){
                    col = 0;
                    row++;
                }
            }
            eso.close();


        } catch (Exception e) {
            System.out.println("Hay error LeerTerreno" + e);
        }
    }*/

    public void draw(Graphics2D g2){
        //completar
        /*int coll = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while(coll< ventanaColum && row < ventanaRow){
            //int tileNum = posTile[col][row];
            //g2.drawImage(tile[tileNum].imagen, x, y,sizeCelda, sizeCelda, null);
            g2.drawRect(x, y, 16, 16);
            coll++;
            x = x + sizeCelda;
            if (coll == ventanaColum){
                coll = 0;
                x = 0; 
                row++;
                y = y + sizeCelda;  
            }
        }*/

        for (int fila = 0; fila < posTile.length; fila++) {
            for (int col = 0; col < posTile[0].length; col++) {
                int tipo = posTile[fila][col];
                g2.drawImage(tile[tipo].imagen, col * sizeCelda, fila * sizeCelda, null);
            }
        }
       
    }

    public void eliminarTile(int fila, int colum){
        if(fila >= 0 && fila < posTile.length && colum >= 0 && colum < posTile[0].length){
            posTile[fila][colum] = 0; // Asignar el valor 0 para eliminar el tile
        } else {
            System.out.println("Índices fuera de rango: fila=" + fila + ", colum=" + colum);
        }
    }

    public boolean esSolido(int fila, int col) {
        if (fila < 0 || fila >= posTile.length || col < 0 || col >= posTile[0].length)
            return false;
        return tile[posTile[fila][col]].esSolido;
    }

    public int[][] getMapa() {
        return posTile;
    }

    public Tile[] getTiles() {
        return tile;
    }


   
}
