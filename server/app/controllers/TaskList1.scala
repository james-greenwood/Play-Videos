package controllers

import javax.inject._

import play.api.mvc._
import play.api.i18n._

@Singleton
class TaskList1 @Inject() (cc: ControllerComponents)
    extends AbstractController(cc) {

  private def formatNameAndPwd(name: String, password: String) = {
    s"$name logged in with $password"
  }

  def login = Action {
    Ok(views.html.login1())
  }

  def validateLoginGet(username: String, password: String) = Action {
    Ok(formatNameAndPwd(username, password))
  }

  def validateLoginPost = Action { request =>
    val postVals = request.body.asFormUrlEncoded
    postVals
      .map { args =>
        val username = args("username").head
        val password = args("password").head
        Redirect(routes.TaskList1.taskList())
      }
      .getOrElse(
        Redirect(routes.TaskList1.login())
      )

  }

  def taskList = Action {
    val tasks = List("task 1", "task 22", "task 3")
    Ok(views.html.taskList1(tasks))
  }

}
