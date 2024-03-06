function Tabela({vetor,selecao}) {
    return(
        <table className="table table-secondary table-striped">
            <thead className="table-light">
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Sobrenome</th>
                    <th>Telefone</th>
                    <th>Selecionar</th>
                </tr>
            </thead>

            <tbody>
                {
                    vetor.map((obj, indice) => (
                        <tr key={indice}>
                            <td>{obj.id}</td>
                            <td>{obj.firstname}</td>
                            <td>{obj.lastname}</td>
                            <td>{obj.phone}</td>
                            <td><button className="btn btn-success" onClick={() => {selecao(indice)}}>Selecionar</button></td>
                        </tr>
                    ))
                }
            </tbody>
        </table>
    )
}

export default Tabela;