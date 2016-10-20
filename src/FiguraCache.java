
import java.util.HashMap;
import java.util.Map;

/**
 * Created by blackwidow on 19/10/16.
 */
public class FiguraCache {
    private static FiguraCache cache = null;
    private Map<String, Forma> figuraMap = new HashMap<>();

    private FiguraCache(){}

    public static synchronized FiguraCache getInstance(){
        if(cache == null){
            cache = new FiguraCache();
            FiguraCache.getInstance().figuraMap.put("cuadrado", new Cuadrado());
            FiguraCache.getInstance().figuraMap.put("circulo", new Circulo());
            FiguraCache.getInstance().figuraMap.put("linea", new Linea());
            FiguraCache.getInstance().figuraMap.put("poligono", new Poligono());
            FiguraCache.getInstance().figuraMap.put("punto", new Punto());
            FiguraCache.getInstance().figuraMap.put("rectangulo", new Rectangulo());
            FiguraCache.getInstance().figuraMap.put("texto", new Texto());
        }
        return cache;
    }

    public Forma getCopiaForma(String nom) throws CloneNotSupportedException {
        Forma f = figuraMap.get(nom);
        return f.clone();
    }
}
