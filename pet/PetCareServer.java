package pet;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface PetCareServer {

    @WebMethod
    public String cadastrarUsuario(String nome, String telefone, String endereco);

    @WebMethod
    public String getUsuario(String id);

    @WebMethod
    public String atualizarTelefoneUsuario(String id, String novoTelefone);

    @WebMethod
    public String excluirUsuario(String id);

    @WebMethod
    public String agendarServicos(String idServico, String idUsuario, String idCachorro, String observacao);

    @WebMethod
    public String listarServicos();

    @WebMethod
    public String mudarObservacao(String id, String observacao);

    @WebMethod
    public String removerServico(String servicoId, String idUsuario);

    @WebMethod
    public String cadastrarCachorro(String idUsuario, String nome, String raca, int idade);

    @WebMethod
    public String listarCachorros(String idUsuario);

    @WebMethod
    public String alterarIdadeCachorro(String idCachorro, int idadeNova);

    @WebMethod
    public String removerCachorro(String idCachorro, String idUsuario);

}