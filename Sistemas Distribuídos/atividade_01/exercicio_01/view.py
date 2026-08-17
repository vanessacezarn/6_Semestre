
class View:   
    """
    Classe responsável pela exibição de informações para o usuário final
    """    
    def exibir_saldo_final(self, saldo):
        """
        Exibe o saldo final do banco central.
        Args:
            saldo (int):  O saldo final é composto pela soma das vendas dos 5 caixas
        """        
        print(f"Saldo final no banco central: {saldo}")