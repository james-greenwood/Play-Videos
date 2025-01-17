package controllers

import javax.inject._

import shared.SharedMessages
import play.api.mvc._
import play.api.i18n._

@Singleton
class Application @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def index = Action {
    Ok(views.html.index(SharedMessages.itWorks))
  }

  def product(prodType: String, num: Int) = Action {
    Ok(s"Product type is $prodType and num is $num")
  }
  
}
