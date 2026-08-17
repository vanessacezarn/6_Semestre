from controller import Controller
from model import Model
from view import View

def main():
    """
    Inicializa a view, model e a controller
    executa o sistema por meio da controller
    """        
    model = Model()
    view = View()
    controller = Controller(model, view)
    controller.executar()
    
if __name__ == "__main__":
    main()