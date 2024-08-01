package com.example.back.common.object;

import java.util.List;
import java.util.ArrayList;

import com.example.back.entity.ClientEntity;

import lombok.Getter;

@Getter

public class ClientListItem {

    private Integer clientCategory;
    private String clientName;
    private String clientOwner;
    private String clientTel;
    private String clientAddress1;

    private ClientListItem(ClientEntity clientEntity) throws Exception {
        this.clientCategory = clientEntity.getClientCategory();
        this.clientName = clientEntity.getClientName();
        this.clientOwner = clientEntity.getClientOwner();
        this.clientTel = clientEntity.getClientTel();
        this.clientAddress1 = clientEntity.getClientAddress1();
    }

    public static List<ClientListItem> getList(List<ClientEntity> clientEntities) throws Exception {

        List<ClientListItem> clientList = new ArrayList<>();
        for (ClientEntity clientEntity: clientEntities) {
            ClientListItem clientListItem = new ClientListItem(clientEntity);
            clientList.add(clientListItem);
        }
        return clientList;
    }

    public static List<ClientListItem> getListByCategory(List<ClientEntity> clientEntities, Integer clientCategory) throws Exception {

        List<ClientListItem> clientList = new ArrayList<>();
        for (ClientEntity clientEntity: clientEntities) {
            if (clientEntity.getClientCategory().equals(clientCategory)) {
                ClientListItem clientListItem = new ClientListItem(clientEntity);
                clientList.add(clientListItem);
            }
        }
        return clientList;
    }

}
