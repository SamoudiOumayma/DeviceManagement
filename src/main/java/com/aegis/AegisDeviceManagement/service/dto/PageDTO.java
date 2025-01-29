package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class PageDTO {

private UUID pageId;
private String pageName;
private String condition;
private String canvas;
private UUID templateId;
}
