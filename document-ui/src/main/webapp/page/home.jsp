<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html;charset=UTF-8">
<!-- Force latest IE rendering engine or ChromeFrame if installed -->
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<![endif]-->
<meta name="google" value="notranslate">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document Handler</title>
<%@include file="common/headerStyle.jsp" %>
<%@include file="common/headerScript.jsp" %>
</head>
<body>
<div id="uiGlobal" class="uiGlobal">
  <div class="uiSubGlobal uiHeader">
    <div class="uiLoginNagivation">
      <div class="uiLoginAvatar"></div>
    </div>
  </div>
</div>
<div id="uiGBA"></div>
<div class="clearBoth"></div>
<div id="uiDocumentList" class="uiDocumentList">
  <div class="uiSplitPane">
    <table cellspacing="0" cellpadding="0" border="0">
      <tbody>
        <tr>
          <td id="uiNavPaneLeft" class="uiNavpaneResizeTransition" valign="top">
            <div id="uiNavPane" class="uiNavPane fixedMargin" style="height: 297px; width: 186px;">
              <div class="uiProductLogo uiDensityTiny">
                <a href="#">Files Manager</a>
              </div>
              <div class="uiCreationPane uiDensityTiny">
                <div class="inlineBlock uiJFKButton uiJFKButtonPrimary uiToolbarItemNew" tabindex="0" style="-webkit-user-select: none;">
                  <div class="inlineBlock">
                    <div class="inlineBlock">
                      <div class="inlineBlock">CREATE</div>
                      <div class="inlineBlock uiJFKButtonDropdown">&nbsp;</div>
                    </div>
                  </div>
                </div>
                <div class="inlineBlock uiJFKButton uiJFKButtonPrimary uiJFKButtonNarrow uiToolbarItemNew uiJFKButtonHover" tabindex="0" style="-webkit-user-select: none;">
                  <div class="inlineBlock">
                    <div class="inlineBlock">
                      <div class="inlineBlock">
                        <span class="uiDriveSpriteCoreUpload uiUploadIconPosition inlineBlock"></span>
                      </div>
                      <div class="inlineBlock uiJFKButtonDropdown">&nbsp;</div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </td>
          <td id="uiNavPaneMiddle" class="uiNavpaneResizeTransition" valign="top"></td>
          <td id="uiNavPaneRight" class="uiNavpaneResizeTransition" valign="top">
            <div id="uiViewPane" class="uiViewPane">
              <div id="uiViewPaneToolBar" class="uiViewPaneToolBar uiDensityTiny">
                <div class="inlineBlock uiViewpaneToolbarSelection">
                  <div class="inlineBlock uiJFKButton uiJFKButtonStandard uiToolbarItemCollectionButton" style="-webkit-user-select: none;" tabindex="0">
                    <div class="uiViewpaneToolbarCollectionIcon uiDriveSpriteCoreNewFolder"></div>
                  </div>
                  <div class="inlineBlock uiJFKButton uiJFKButtonStandard uiToolbarItemShareButton" style="-webkit-user-select: none;" tabindex="0">
                    <div class="uiViewpaneToolbarShareIcon uiDriveSpriteCoreShare"></div>
                  </div>
                  <div class="inlineBlock uiJFKButton uiJFKButtonStandard uiJFKButtonCollapseLeft uiJFKButtonCollapseRight" style="-webkit-user-select: none;" tabindex="0">
                    <div class="uiViewpaneToolbarOrganizeIcon uiDriveSpriteCoreOrganize"></div>
                  </div>
                  <div class="inlineBlock uiJFKButton uiJFKButtonStandard uiJFKButtonCollapseLeft" style="-webkit-user-select: none;" tabindex="0">
                    <div class="uiViewpaneToolbarTrashIcon uiDriveSpriteCoreTrash"></div>
                  </div>
                </div>
              </div>
              
              <!-- Documents View Pane -->
              <table class="uiViewPaneContent">
                <tbody>
                  <tr>
                    <td class="uiViewPaneList">
                      <div class="uiBannerBox uiDensityTiny" style="height: 0px;"></div>
                      <div id="uiViewManager">
                        <div class="uiDocListView" style="height: 201px;">
                          <div class="uiDocListViewInner viewInfoVisible" style="height: 201px;">
                            <!-- Navigation Bar -->
                            <div class="uiDocListViewFixedContainer uiDensityTiny" style="width: 1026px;">
                              <div class="uiFolderPathContainer uiDocumentContainer" style="-webkit-user-select: none;">
                                <div class="uiInlineBlock uiFolderPathFolder uiFolderPathElement" id=":36.folder.0AFFRuQEFr06pUk9PVA" tabindex="0">My Drive</div>
                                <div class="uiInlineBlock uiFolderPathSeparatorIcon"></div>
                                <div class="uiInlineBlock uiFolderPathFolder uiFolderCurrentElement" id=":36.folder.0B1FRuQEFr06pMW9MRWRhZW1Sc3c">01. Scrum Template</div>
                              </div>
                            </div>
                            <!-- Contents -->
                            
                          </div>
                        </div>
                      </div>
                    </td>
                  </tr>
                </tbody>
              </table>
            </div>
          </td>
        </tr>
      </tbody>
    </table>
  </div>
</div>
<div class="uiMenuBlock uiMenuBlockVertical uiUploadMenu uiDensityTiny" style="-webkit-user-select: none; visibility: visible; left: -10000px; top: 0px; display: none;">
  <div class="uiMenuItem" style="-webkit-user-select: none;">
    <div class="goog-menuitem-content" style="-webkit-user-select: none;">
      <span class="uiMenuItemIcon uiDetroitMenuInlineBlock" style="-webkit-user-select: none;">&nbsp;</span>
      <span class="goog-menuitem-container uiDetroitMenuInlineBlock" style="-webkit-user-select: none;">
        <span class="goog-menuitem-caption uiDetroitMenuInlineBlock" style="-webkit-user-select: none;">
          <div style="-webkit-user-select: none;">Files...</div>
        </span>
        <span class="goog-menuitem-subcaption detroit-menu-inline-block" style="-webkit-user-select: none;">
          <div style="-webkit-user-select: none;"></div>
        </span>
      </span>
    </div>
  </div>
  <input type="file" name="files[]" multiple style="height: 0px; visibility: hidden; position: absolute; -webkit-user-select: none; width: 182px; font-size: inherit;">
</div>
</body>
</html>