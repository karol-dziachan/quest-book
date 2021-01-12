package com.example.database.logic;

import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CommDAO {
    private final DataSource dataSource;

    public CommDAO()
    {
        try{
            this.dataSource = DataSourceProvider.getDataSource();
        }catch(NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Comment> findAll(){
        final String sql = "SELECT author, description FROM quest";
        List<Comment> comments = new ArrayList<>();

        try (Connection connection = dataSource.getConnection()){

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");

                comments.add(new Comment(author, description));
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

        return comments;
    }

    public void add(Comment comment)
    {
        String sql = String.format("INSERT INTO quest (author, description) VALUES('%s', '%s')",
                comment.getAuthor(), comment.getDescription());

        try(Connection connection = DataSourceProvider.getDataSource().getConnection();
            Statement statement = connection.createStatement())
        {
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();

            if(generatedKeys.next())
                comment.setId(1);
        } catch (SQLException | NamingException e) {
            throw new RuntimeException(e);
        }
    }
}
