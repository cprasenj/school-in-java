package hello;

import com.mongodb.*;

import java.net.UnknownHostException;

public class DB{

    private com.mongodb.DB db;
    private DBCollection coll;


    public DB (){
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient();
            mongoClient.setWriteConcern(WriteConcern.JOURNALED);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        this.db = mongoClient.getDB( "mydb" );
        insert();
    }

    private void insert() {
        coll = db.getCollection("testCollection");
        BasicDBObject doc = new BasicDBObject("name", "MongoDB")
                .append("type", "database")
                .append("count", 1)
                .append("info", new BasicDBObject("x", 203).append("y", 102));
        coll.insert(doc);
    }

    public void  getColl() {
        DBObject myDoc = coll.findOne();
        System.out.println(myDoc);
    }
}


