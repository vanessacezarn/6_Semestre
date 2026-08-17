from controller import Controller
from model import Banco
from view import View

def main():
    """
    Inicializa a view, model(banco) e a controller
    executa o sistema por meio da controller
    """        
    banco = Banco()
    view = View()
    controller = Controller(banco, view)

    controller.executar()
    
if __name__ == "__main__":
    main()