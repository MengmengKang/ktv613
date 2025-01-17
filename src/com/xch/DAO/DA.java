package com.xch.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.xch.obj.AdminData;
import com.xch.obj.SongData;
import com.xch.obj.StarData;
import com.xch.obj.UserData;

public class DA
{
    final static String DB = "ktv613";

    // final static String ID="root";
    // final static String PW="";
    static String ID = "";

    static String PW = "";

    final static String CONNECT = "jdbc:mysql://localhost:3306/" + DB
            + "?useUnicode=true&characterEncoding=utf8";

    static Connection aConnection;

    static Statement aStatement;

    public static void readConfig()
    {
        final File file = new File("config.ini");

        try
        {
            final BufferedReader reader = new BufferedReader(new FileReader(
                    file));

            String tempString;

            while ((tempString = reader.readLine()) != null)
            {
                // 显示行号
                if (tempString.startsWith("ID="))
                {
                    ID = tempString.substring(3);
                }
                if (tempString.startsWith("PW="))
                {
                    PW = tempString.substring(3);
                }
            }

            reader.close();

            DA.open();
            DA.close();
        }
        catch (final IOException e1)
        {
            // TODO Auto-generated catch block
            JOptionPane.showMessageDialog(null,
                    "无法打开配置文件“config.ini”\n请检查该配置文件是否存在");
            e1.printStackTrace();
        }
    }

    public static void open()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            aConnection = DriverManager.getConnection(CONNECT, ID, PW);
            aStatement = aConnection.createStatement();
        }
        catch (final Exception e)
        {

            // TODO: handle exception
            System.out.println(e);
            JOptionPane.showMessageDialog(null,
                    "数据库连接失败！\n请检查配置文件“config.ini”中的用户名以及密码是否错误");
            System.exit(0);
        }
    }

    public static void close()
    {
        try
        {
            aStatement.close();
            aConnection.close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static int getUserMaxID()
    {
        int MaxID = 1;
        try
        {
            open();
            final String sql = "select userid from users order by userid";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getInt(1) != MaxID)
                {
                    break;
                }
                MaxID++;
            }
            close();

        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return MaxID;
    }

    public static int getSongMaxID()
    {
        int MaxID = 1;
        try
        {
            open();
            final String sql = "select songid from songs order by songid";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getInt(1) != MaxID)
                {
                    break;
                }
                MaxID++;
            }
            close();

        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return MaxID;
    }

    public static int getStarMaxID()
    {
        int MaxID = 1;
        try
        {
            open();
            final String sql = "select starid from stars order by starid";
            System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getInt(1) != MaxID)
                {
                    break;
                }
                MaxID++;
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return MaxID;
    }

    public static boolean checkUserName(final String username)
    {
        boolean flag = false;
        try
        {
            open();
            final String sql = "select username from users";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getString(1).compareTo(username) == 0)
                {
                    flag = true;
                    break;
                }
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return flag;
    }

    public static boolean checkAdmin(final String admin)
    {
        boolean flag = false;
        try
        {
            open();
            final String sql = "select admin from admins";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getString(1).compareTo(admin) == 0)
                {
                    flag = true;
                    break;
                }
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return flag;
    }

    public static boolean checkStarName(final String starname)
    {
        boolean flag = false;
        try
        {
            open();
            final String sql = "select starname from stars";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                if (result.getString(1).compareTo(starname) == 0)
                {
                    flag = true;
                    break;
                }
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return flag;
    }

    public static boolean loginUser(final UserData user)
    {
        boolean flag = false;
        try
        {
            open();
            final String sql = "select username,password from users";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                // System.out.println("s "+result.getString(1)+" "+result.getString(2));
                // System.out.println("t "+user.getUserName()+" "+user.getPassWord());
                if (result.getString(1).compareTo(user.getUserName()) == 0
                        && result.getString(2).compareTo(user.getPassWord()) == 0)
                {
                    flag = true;
                    break;
                }
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return flag;
    }

    public static boolean loginAdmin(final AdminData admin)
    {
        boolean flag = false;
        try
        {
            open();
            final String sql = "select * from admins";
            final ResultSet result = aStatement.executeQuery(sql);
            while (result.next())
            {
                // System.out.println("s "+result.getString(1)+" "+result.getString(2));
                // System.out.println("t "+admin.getAdmin()+" "+admin.getPassWord());
                if (result.getString(1).compareTo(admin.getAdmin()) == 0
                        && result.getString(2).compareTo(admin.getPassWord()) == 0)
                {
                    flag = true;
                    break;
                }
            }
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
        return flag;
    }

    public static String[][] orderByPinyin(final String indata, final int n)
    {
        String[][] res = {};

        try
        {
            open();

            final String sql = "select * from songs,stars where (SoPinYin like '"
                    + indata
                    + "%' OR SoPinYin like '"
                    + indata
                    + "%') AND songs.StarID=stars.StarID";
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(5);
                resLine[2] = result.getString(2);
                resLine[3] = result.getString(3);
                resLine[4] = result.getString(9);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] orderBySongName(final String indata, final int n)
    {
        String[][] res = {};

        try
        {
            open();

            final String sql = "select * from songs,stars where (SongName like '"
                    + indata
                    + "' OR SongName like '%"
                    + indata
                    + "' OR SongName like '"
                    + indata
                    + "%' OR SongName like '%"
                    + indata
                    + "%') AND songs.StarID=stars.StarID";
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(5);
                resLine[2] = result.getString(2);
                resLine[3] = result.getString(3);
                resLine[4] = result.getString(9);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] orderBySongNumber(final int indata, final int n)
    {
        String[][] res = {};

        try
        {
            open();

            final String sql = "select * from songs,stars where SoNumber="
                    + indata + " AND songs.StarID=stars.StarID";
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(5);
                resLine[2] = result.getString(2);
                resLine[3] = result.getString(3);
                resLine[4] = result.getString(9);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] orderByStar(final String indata, final int n)
    {
        String[][] res = {};

        try
        {
            open();

            final String sql = "select * from songs,stars where (StarName like '"
                    + indata
                    + "' OR StarName like '%"
                    + indata
                    + "' OR StarName like '"
                    + indata
                    + "%' OR StarName like '%"
                    + indata
                    + "%') AND songs.StarID=stars.StarID";
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(5);
                resLine[2] = result.getString(2);
                resLine[3] = result.getString(3);
                resLine[4] = result.getString(9);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String getSongURL(final int indata)
    {
        String res = null;

        try
        {
            open();

            final String sql = "select URL from songs where SongID=" + indata;
            final ResultSet result = aStatement.executeQuery(sql);
            result.next();
            res = result.getString(1);

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static void modifySongData(final SongData song)
    {
        try
        {
            open();
            String sql = "update users set ";
            sql = sql + "songname='" + song.getSongName() + "',";
            sql = sql + "songtype='" + song.getSongType() + "',";
            sql = sql + "sonumber=" + song.getSoNumber() + ",";
            sql = sql + "sopinyin='" + song.getSoPinYin() + "',";
            sql = sql + "starid=" + song.getStarID() + ",";
            sql = sql + "url='" + song.getURL() + "' ";
            sql = sql + "where songid=" + song.getSongID();

            System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void delSong(final int songid)
    {
        try
        {
            open();
            final String sql = "delete from songs where songid=" + songid;

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void delStar(final int starid)
    {
        try
        {
            open();
            String sql = "delete from stars where starid=" + starid;

            aStatement.executeUpdate(sql);

            sql = "delete from songs where starid=" + starid;

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void delUser(final int userid)
    {
        try
        {
            open();
            final String sql = "delete from users where userid=" + userid;

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void delAdmin(final String Admin)
    {
        try
        {
            open();
            final String sql = "delete from admins where admin='" + Admin + "'";

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static String[][] listAdmin()
    {
        String[][] res = {};
        final int n = 1;
        try
        {
            open();

            final String sql = "select * from admins";
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] listStar()
    {
        String[][] res = {};
        final int n = 5;
        try
        {
            open();

            final String sql = "select * from stars";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(2);
                resLine[3] = result.getString(4);
                resLine[4] = result.getString(5);
                if (result.getInt(3) == 1)
                {
                    resLine[2] = "男";
                }
                else
                {
                    resLine[2] = "女";
                }
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] listUser()
    {
        String[][] res = {};
        final int n = 6;
        try
        {
            open();

            final String sql = "select * from users";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(2);
                resLine[2] = result.getString(4);
                resLine[3] = result.getString(5);
                if (result.getInt(6) == 1)
                {
                    resLine[4] = "男";
                }
                else
                {
                    resLine[4] = "女";
                }
                resLine[5] = result.getString(7);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[][] listSong()
    {
        String[][] res = {};
        final int n = 7;
        try
        {
            open();

            final String sql = "select * from songs,stars where songs.starid=stars.starid";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row][n];
            int i = -1;
            while (result.next())
            {
                i++;
                final String[] resLine = new String[n];
                // System.out.println(result.getString(5)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(9));
                resLine[0] = result.getString(1);
                resLine[1] = result.getString(2);
                resLine[2] = result.getString(3);
                resLine[3] = result.getString(4);
                resLine[4] = result.getString(5);
                resLine[5] = result.getString(9);
                resLine[6] = result.getString(7);
                res[i] = resLine;
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static AdminData getAdmin(final String admin)
    {
        final AdminData res = new AdminData();
        try
        {
            open();

            final String sql = "select * from admins where admin='" + admin
                    + "'";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.next();
            res.setAdmin(result.getString(1));
            res.setPassWord(result.getString(2));

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static StarData getStar(final int starid)
    {
        final StarData res = new StarData();
        try
        {
            open();

            final String sql = "select * from stars where starid='" + starid
                    + "'";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.next();
            res.setStarID(result.getInt(1));
            res.setStarName(result.getString(2));
            res.setGender(result.getInt(3));
            res.setComeFrom(result.getString(4));
            res.setTeam(result.getString(5));

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static String[] getStarNameList()
    {
        String[] res = null;
        try
        {
            open();

            final String sql = "select starname from stars order by starid";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new String[row];
            int i = -1;

            while (result.next())
            {
                i++;
                res[i] = result.getString(1);
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static int[] getStarIDList()
    {
        int[] res = null;
        try
        {
            open();

            final String sql = "select starid from stars order by starid";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.last();
            final int row = result.getRow();
            result.beforeFirst();
            res = new int[row];
            int i = -1;

            while (result.next())
            {
                i++;
                res[i] = result.getInt(1);
            }

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static UserData getUser(final int userid)
    {
        final UserData res = new UserData();
        try
        {
            open();

            final String sql = "select * from users where userid='" + userid
                    + "'";
            // System.out.println(sql);
            final ResultSet result = aStatement.executeQuery(sql);
            result.next();
            res.setUserID(result.getInt(1));
            res.setUserName(result.getString(2));
            res.setPassWord(result.getString(3));
            res.setRealName(result.getString(4));
            res.setEmail(result.getString(5));
            res.setGender(result.getInt(6));
            res.setInterest(result.getString(7));

            close();
        }
        catch (final Exception e)
        {
            System.out.println();
        }
        return res;
    }

    public static void modifyAdmin(final AdminData Admin)
    {
        try
        {
            open();
            String sql = "update admins set ";
            sql = sql + "PassWord='" + Admin.getPassWord() + "'";
            sql = sql + " where Admin='" + Admin.getAdmin() + "'";

            System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void modifyStar(final StarData star)
    {
        try
        {
            open();
            String sql = "update stars set ";
            sql = sql + "StarName='" + star.getStarName() + "',";
            sql = sql + "Gender=" + star.getGender() + ",";
            sql = sql + "ComeFrom='" + star.getComeFrom() + "',";
            sql = sql + "Team='" + star.getTeam() + "'";
            sql = sql + " where StarID=" + star.getStarID();

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void addStar(final StarData star)
    {
        try
        {
            open();
            String sql = "insert stars values (";
            sql = sql + star.getStarID() + ",";
            sql = sql + "'" + star.getStarName() + "',";
            sql = sql + star.getGender() + ",";
            sql = sql + "'" + star.getComeFrom() + "',";
            sql = sql + "'" + star.getTeam() + "')";

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void addAdmin(final AdminData admin)
    {
        try
        {
            open();
            String sql = "insert admins values('" + admin.getAdmin() + "',";
            sql = sql + "'" + admin.getPassWord() + "')";

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void addUser(final UserData user)
    {
        try
        {
            open();
            String sql = "insert users values(" + user.getUserID() + ",";
            sql = sql + "'" + user.getUserName() + "',";
            sql = sql + "'" + user.getPassWord() + "',";
            sql = sql + "'" + user.getRealName() + "',";
            sql = sql + "'" + user.getEmail() + "',";
            sql = sql + user.getGender() + ",";
            sql = sql + "'" + user.getInterest() + "')";

            // System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void addSong(final SongData song)
    {
        try
        {
            open();

            final String oldurl = song.getURL();
            String url = "";
            for (int i = 0; i < oldurl.length(); i++)
            {
                url = url.concat(oldurl.substring(i, i + 1));
                if (oldurl.substring(i, i + 1).compareTo("\\") == 0)
                {
                    url = url.concat(oldurl.substring(i, i + 1));
                }
            }

            String sql = "insert songs values(" + song.getSongID() + ",";
            sql = sql + "'" + song.getSongName() + "',";
            sql = sql + "'" + song.getSongType() + "',";
            sql = sql + song.getSoNumber() + ",";
            sql = sql + "'" + song.getSoPinYin() + "',";
            sql = sql + song.getStarID() + ",";
            sql = sql + "'" + url + "')";

            System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public static void modifyUser(final UserData user)
    {
        try
        {
            open();
            String sql = "update users set ";
            sql = sql + "username='" + user.getUserName() + "',";
            sql = sql + "password='" + user.getPassWord() + "',";
            sql = sql + "realname='" + user.getRealName() + "',";
            sql = sql + "email='" + user.getEmail() + "',";
            sql = sql + "gender=" + user.getGender() + ",";
            sql = sql + "interest='" + user.getInterest() + "' ";
            sql = sql + "where userid=" + user.getUserID();

            System.out.println(sql);

            aStatement.executeUpdate(sql);
            close();
        }
        catch (final Exception e)
        {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}
