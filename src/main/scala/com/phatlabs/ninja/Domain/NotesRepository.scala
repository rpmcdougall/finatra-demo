package com.phatlabs.ninja.Domain

import com.google.inject.{Inject, Singleton}
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future


@Singleton
class UserRepository @Inject()(val driver: JdbcProfile) {
  import driver.api._

  /*
    We are assuming we have a table named 'USERS' that has the following columns:
    - IDT_USER (number, auto inc, PK)
    - DES_USERNAME (varchar)
    - NUM_AGE (number)
    - DES_OCCUPATION (varchar)
   */
  class Notes(tag: Tag) extends Table[(Option[Long], String, String)](tag, "NOTES") {
    def id = column[Long]("ID", O.AutoInc, O.PrimaryKey)
    def title = column[String]("TITLE")
    def content = column[String]("CONTENT")

    override def * = (id.?, title, content)
  }

  val notes: TableQuery[Notes] = TableQuery[Notes]
  val db: driver.backend.DatabaseDef = Database.forConfig("myDb")

  def create = {
    notes.schema.create
  }


//  def findById(id: Long): Future[Seq[(Option[Long], String, String)]] = {
//    val query = notes.filter(_.id === id).result
//    db.run(query).map({
//      case Nil => None
//      case x +: Nil => Some(x)
//    })
//  }

  def create(user: (Option[Long], String, String)): Future[Option[Long]] = {
    val action: DBIO[Seq[Long]] = (notes returning notes.map(_.id)) ++= Iterable()
    db.run(action).map({
      case Nil => None
      case x +: Nil => Some(x)
    })
  }
}
