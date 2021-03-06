<?php
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.24.0-fcfceb9 modeling language!*/

class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private $orderDate;
  private $orderTime;

  /**
   * Has the order been paid by the customer ?
   */
  private $paid;

  /**
   * Has the order been served to the customer ?
   */
  private $served;

  //Order Associations
  private $menuItems;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public function __construct($aOrderDate, $aOrderTime, $aPaid, $aServed)
  {
    $this->orderDate = $aOrderDate;
    $this->orderTime = $aOrderTime;
    $this->paid = $aPaid;
    $this->served = $aServed;
    $this->menuItems = array();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public function setOrderDate($aOrderDate)
  {
    $wasSet = false;
    $this->orderDate = $aOrderDate;
    $wasSet = true;
    return $wasSet;
  }

  public function setOrderTime($aOrderTime)
  {
    $wasSet = false;
    $this->orderTime = $aOrderTime;
    $wasSet = true;
    return $wasSet;
  }

  public function setPaid($aPaid)
  {
    $wasSet = false;
    $this->paid = $aPaid;
    $wasSet = true;
    return $wasSet;
  }

  public function setServed($aServed)
  {
    $wasSet = false;
    $this->served = $aServed;
    $wasSet = true;
    return $wasSet;
  }

  public function getOrderDate()
  {
    return $this->orderDate;
  }

  public function getOrderTime()
  {
    return $this->orderTime;
  }

  public function getPaid()
  {
    return $this->paid;
  }

  public function getServed()
  {
    return $this->served;
  }

  public function isPaid()
  {
    return $this->paid;
  }

  public function isServed()
  {
    return $this->served;
  }

  public function getMenuItem_index($index)
  {
    $aMenuItem = $this->menuItems[$index];
    return $aMenuItem;
  }

  public function getMenuItems()
  {
    $newMenuItems = $this->menuItems;
    return $newMenuItems;
  }

  public function numberOfMenuItems()
  {
    $number = count($this->menuItems);
    return $number;
  }

  public function hasMenuItems()
  {
    $has = $this->numberOfMenuItems() > 0;
    return $has;
  }

  public function indexOfMenuItem($aMenuItem)
  {
    $wasFound = false;
    $index = 0;
    foreach($this->menuItems as $menuItem)
    {
      if ($menuItem->equals($aMenuItem))
      {
        $wasFound = true;
        break;
      }
      $index += 1;
    }
    $index = $wasFound ? $index : -1;
    return $index;
  }

  public static function minimumNumberOfMenuItems()
  {
    return 0;
  }

  public function addMenuItem($aMenuItem)
  {
    $wasAdded = false;
    if ($this->indexOfMenuItem($aMenuItem) !== -1) { return false; }
    $this->menuItems[] = $aMenuItem;
    $wasAdded = true;
    return $wasAdded;
  }

  public function removeMenuItem($aMenuItem)
  {
    $wasRemoved = false;
    if ($this->indexOfMenuItem($aMenuItem) != -1)
    {
      unset($this->menuItems[$this->indexOfMenuItem($aMenuItem)]);
      $this->menuItems = array_values($this->menuItems);
      $wasRemoved = true;
    }
    return $wasRemoved;
  }

  public function addMenuItemAt($aMenuItem, $index)
  {  
    $wasAdded = false;
    if($this->addMenuItem($aMenuItem))
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfMenuItems()) { $index = $this->numberOfMenuItems() - 1; }
      array_splice($this->menuItems, $this->indexOfMenuItem($aMenuItem), 1);
      array_splice($this->menuItems, $index, 0, array($aMenuItem));
      $wasAdded = true;
    }
    return $wasAdded;
  }

  public function addOrMoveMenuItemAt($aMenuItem, $index)
  {
    $wasAdded = false;
    if($this->indexOfMenuItem($aMenuItem) !== -1)
    {
      if($index < 0 ) { $index = 0; }
      if($index > $this->numberOfMenuItems()) { $index = $this->numberOfMenuItems() - 1; }
      array_splice($this->menuItems, $this->indexOfMenuItem($aMenuItem), 1);
      array_splice($this->menuItems, $index, 0, array($aMenuItem));
      $wasAdded = true;
    } 
    else 
    {
      $wasAdded = $this->addMenuItemAt($aMenuItem, $index);
    }
    return $wasAdded;
  }

  public function equals($compareTo)
  {
    return $this == $compareTo;
  }

  public function delete()
  {
    $this->menuItems = array();
  }

}
?>