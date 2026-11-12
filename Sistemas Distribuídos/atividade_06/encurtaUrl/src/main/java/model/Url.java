package model;

import java.util.Objects;

public class Url {
    
    String enderecoUrl;
    String urlEncurtada;

    public Url(String enderecoUrl, String urlEncurtada) {
        this.enderecoUrl = enderecoUrl;
        this.urlEncurtada = urlEncurtada;
    }

    public String getEnderecoUrl() {
        return enderecoUrl;
    }

    public void setEnderecoUrl(String enderecoUrl) {
        this.enderecoUrl = enderecoUrl;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.enderecoUrl);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Url other = (Url) obj;
        return Objects.equals(this.enderecoUrl, other.enderecoUrl);
    }
    
}
