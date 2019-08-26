package itsight.bancamovil.io.service.network;

import java.util.List;

import itsight.bancamovil.io.model.Cliente;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface BancaMovilApiService {

    @GET(BancaMovilApiConstants.GET_ALL_PATH)
    public Call<List<Cliente>> loadRepo();

    @GET(BancaMovilApiConstants.GET_ONE_PATH)
    public Call<Cliente> One_Cliente(@Path("idCliente") int idCliente);

    @GET(BancaMovilApiConstants.GET_HOLA)
    public Call<String> Hola();
}
