package model.dao.utils;

public class BooksDaoUtils {
    public static String refactorGenreStringToStringForSQL(String genreString){
        String[] arrStr = genreString.trim().split(",");
        StringBuilder sb = new StringBuilder();
        for(String str : arrStr)
            sb.append("'%" + str.trim() + "%' ");
        return sb.toString();
    }
}
